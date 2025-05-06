package controller;

import java.util.ArrayList;
import model.Environment;
import model.Grid;
import model.Element;


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

    public void evolve(long interval) {
        while (true) {
            try {
                environment.nextGeneration();
                notifySubscribers();
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Environment getEnvironment() {
        return environment;
    }

    public int getHeigth() {
        return environment.getHeigth();
    }

    public int getWidth() {
        return environment.getWidth();
    }

    public Element getCell(int x, int y){
        return environment.getCell(x, y);
    }
}
