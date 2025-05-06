package GUI;

import controller.Subscriber;
import controller.EnvironmentController;
import java.util.Scanner;


public class TerminalView implements Subscriber {
    private EnvironmentController environment;
    private Scanner scanner;
    private Thread checkInput;

    public TerminalView(EnvironmentController environment) {
        this.environment = environment;
        this.environment.add(this);
        scanner = new Scanner(System.in);
        checkInput = new Thread(() -> {
            while (true) {
                scanner.nextLine();
                environment.playOrPause();
            }
        });
        checkInput.start();
    }


    public void stateChanged(EnvironmentController environment) {
        System.out.println("generation n°" + environment.getGenerationNumber() + ":");
        System.out.println(environment);
    }
}
