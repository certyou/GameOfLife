public class Cell {
    private boolean alive;

    public Cell() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public void spawn() {
        alive = true;
    }

    public void kill() {
        alive = false;
    }

    public String toString() {
        if (alive) {return "▉";}
        else {return "🬎";}
    }
}
