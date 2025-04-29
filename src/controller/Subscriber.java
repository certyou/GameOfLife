package controller;


import model.Environment;

public interface Subscriber {
    public void stateChanged(Environment context);
}
