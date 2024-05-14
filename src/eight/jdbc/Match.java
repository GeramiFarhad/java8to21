package eight.jdbc;

public class Match {
    int id;

    boolean completed;

    int nato;

    int creator;

    public Match() {
    }

    public Match(int id, boolean completed, int creator, int nato) {
        this.id = id;
        this.completed = completed;
        this.nato = nato;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getNato() {
        return nato;
    }

    public void setNato(int nato) {
        this.nato = nato;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public String toString() {
        return "Match{" +
                "id=" + id +
                ", creator=" + creator +
                ", completed=" + completed +
                ", nato=" + nato +
                '}';
    }
}
