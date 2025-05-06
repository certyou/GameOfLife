import GUI.GameOfLifeFrame;
import GUI.TerminalView;
import controller.EnvironmentController;

public class App {
    public static void main(String[] args) {
        EnvironmentController environmentController = new EnvironmentController(40,40);
        GameOfLifeFrame frame = new GameOfLifeFrame(environmentController);
        TerminalView terminalView = new TerminalView(environmentController);
        environmentController.evolve(1000);
    }
}
