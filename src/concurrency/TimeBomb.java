package concurrency;

public class TimeBomb {
    public static void main(String[] args) throws InterruptedException {
        Thread timer = new Thread(new CountDown());
        System.out.println("Starting 10 sec count down");
        timer.start();
        timer.join();
        System.out.println("Boom");
    }
}
