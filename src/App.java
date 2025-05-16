import GUI.GameOfLifeFrame;
import GUI.TerminalView;
import controller.GameOfLifeController;
import model.GameOfLifeModel;

public class App {
    public static void main(String[] args) {
        GameOfLifeModel model = new GameOfLifeModel(50,50);
        GameOfLifeFrame frame = new GameOfLifeFrame(model);
        TerminalView terminalView = new TerminalView(model);
        GameOfLifeController controller = new GameOfLifeController(terminalView, frame, model);
        controller.start();
    }
}