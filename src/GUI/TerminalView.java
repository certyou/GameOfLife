package GUI;

import controller.Subscriber;
import controller.EnvironmentController;
import model.Environment;


public class TerminalView implements Subscriber{
    private EnvironmentController environment;

    public TerminalView(EnvironmentController environment) {
        this.environment = environment;
        this.environment.add(this);
    }

    public void stateChanged(Environment environment) {
        //
    }
}
