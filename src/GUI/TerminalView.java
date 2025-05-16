package GUI;

import model.GameOfLifeModel;
import model.Listener;

import java.util.Scanner;


public class TerminalView implements Listener {
    private Scanner scanner;

    public TerminalView(GameOfLifeModel model) {
        scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void stateChanged(GameOfLifeModel environment) {
        System.out.println("generation n°" + environment.getGenerationNumber() + ":");
        System.out.println(environment);
    }
}
