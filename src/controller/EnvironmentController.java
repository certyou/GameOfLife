package controller;

import java.util.ArrayList;
import model.Environment;
import model.Grid;


public class EnvironmentController {
    private Environment environment;
    private ArrayList<Subscriber> subscribers;

    public EnvironmentController(int x, int y) {
        environment = new Grid(x, y);
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
            subscriber.stateChanged(environment);
        }
    }

    public Environment getEnvironment() {
        return environment;
    }
}
