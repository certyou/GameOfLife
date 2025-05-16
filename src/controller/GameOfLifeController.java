package controller;

import model.GameOfLifeModel;
import GUI.GameOfLifeFrame;
import GUI.TerminalView;

public class GameOfLifeController {
    private GameOfLifeModel model;
    private GameOfLifeFrame frame;
    private TerminalView terminal;

    public GameOfLifeController(TerminalView terminal, GameOfLifeFrame frame, GameOfLifeModel model) {
        this.model = model;
        this.frame = frame;
        this.terminal = terminal;
        model.add(frame);
        model.add(terminal);

        this.frame.getStartAndPauseButton().addActionListener(
            (event) -> {
                String buttonText = this.frame.getStartAndPauseButton().getText();
                if (model.isRunning()) {
                    buttonText = "play";
                    model.stop();
                } else {
                    buttonText = "pause";
                    model.start();
                }
                this.frame.getStartAndPauseButton().setText(buttonText);
            }
        );

        Thread checkInput = new Thread(() -> {
            while (true) {
                this.terminal.getScanner().nextLine();
                if (model.isRunning()) {
                    model.stop();
                } else {
                    model.start();
                }
            }
        });
        checkInput.start();
    }

    public int getWidth() {
        return model.getWidth();
    }

    public int getHeigth() {
        return model.getHeigth();
    }

    public int getGenerationNumber() {
        return model.getGenerationNumber();
    }

    public GameOfLifeModel getGameOfLifeModel() {
        return model;
    }

    public void start() {
        model.start();
    }

}
