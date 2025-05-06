package controller;

import java.util.ArrayList;
import model.Environment;
import model.Grid;
import model.Element;


public class EnvironmentController {
    private Environment environment;
    private ArrayList<Subscriber> subscribers;
    private boolean play;

    public EnvironmentController(int x, int y) {
        environment = new Grid(x, y);
        subscribers = new ArrayList<>();
        play = true;
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

    public void play() {
        play = true;
    }

    public void stop() {
        play = false;
    }

    public void evolve(long interval) {
        while (true) {
            while (play) {
                try {
                    environment.nextGeneration();
                    notifySubscribers();
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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

    public int getGenerationNumber() {
        return environment.getGenerationNumber();
    }

    public String toString() {
        return environment.toString();
    }
}
