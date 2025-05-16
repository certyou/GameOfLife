package model;

import java.util.ArrayList;


public class GameOfLifeModel {
    private Environment environment;
    private ArrayList<Listener> Listeners;
    private Thread evolve;

    public GameOfLifeModel(int x, int y) {
        environment = new Grid(x, y);
        Listeners = new ArrayList<>();
    }

    public void add(Listener Listener) {
        Listeners.add(Listener);
    }

    public void remove(Listener Listener) {
        Listeners.remove(Listener);
    }

    public void notifyListeners() {
        for (Listener Listener : Listeners) {
            Listener.stateChanged(this);
        }
    }

    public boolean isRunning() {
        return evolve.isAlive();
    }

    public void start() {
        evolve = new Thread(() -> {
            while (true) {
                try {
                    environment.nextGeneration();
                    notifyListeners();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        evolve.start();
    }

    public void stop() {
        evolve.interrupt();
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
