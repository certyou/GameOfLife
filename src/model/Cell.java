package model;


public class Cell implements Element {
    private boolean alive;

    public Cell() {
        alive = false;
    }

    public Cell(boolean alive) {
        this.alive = alive;
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
