package eight.concurrency;

public class Deadlock {
    public static void go() throws InterruptedException {

        final String ransom = "ransom";
        final String hostage = "hostage";

        Thread criminals = new Thread(
                () -> {
                    synchronized (hostage) {
                        System.out.println("The criminals have the hostage and want the ransom");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        synchronized (ransom) {
                            System.out.println("The criminals have both!");
                        }
                    }
                }
        );

        Thread police = new Thread(
                () -> {
                    synchronized (ransom) {
                        System.out.println("The police have the ransom and want the hostage");

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        synchronized (hostage) {
                            System.out.println("The police have both");
                        }
                    }
                }
        );

        criminals.start();
        police.start();

    }

    public static void main(String[] args) throws InterruptedException {
        go();
    }
}
