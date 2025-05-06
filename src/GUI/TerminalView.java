package GUI;

import controller.Subscriber;
import controller.EnvironmentController;


public class TerminalView implements Subscriber {
    private EnvironmentController environment;

    public TerminalView(EnvironmentController environment) {
        this.environment = environment;
        this.environment.add(this);
    }

    public void stateChanged(EnvironmentController environment) {
        System.out.println("generation n°" + environment.getGenerationNumber() + ":");
        System.out.println(environment);
    }
}
