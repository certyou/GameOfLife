package model;

import java.util.ArrayList;

public class GridController {
    private Grid grid;
    private ArrayList<Subscriber> subscribers;

    public GridController(int x, int y) {
        grid = new Grid(x, y);
        subscribers = new ArrayList<>();
    }

    public void add(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void remove(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.stateChanged(this);
        }
    }

    public void updateGridFromCoordonnates(int x, int y) {
        grid.spawnCell(x, y);
        notifySubscribers();
    }
}
