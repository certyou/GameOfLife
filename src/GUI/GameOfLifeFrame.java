package GUI;

import javax.swing.*;
import java.awt.*;

import model.GameOfLifeModel;
import model.Listener;

public class GameOfLifeFrame extends JFrame implements Listener {
    private JPanel gridPanel;
    private int cellSize = 10;
    private JLabel countLabel;
    private JButton startAndPauseButton;

    public GameOfLifeFrame(GameOfLifeModel model) {
        setTitle("Game of Life");
        setLayout(new BorderLayout());

        // count generation panel
        JPanel countJPanel = new JPanel();
        countLabel = new JLabel("generation n°0");
        countJPanel.add(countLabel);
        add(countJPanel, BorderLayout.NORTH);

        // Create grid panel
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(model.getHeigth(), model.getWidth())); // Adjust grid size as needed
        add(gridPanel, BorderLayout.CENTER);

        // Add control button
        JPanel controlPanel = new JPanel();
        startAndPauseButton = new JButton("pause");
        controlPanel.add(startAndPauseButton);
        add(controlPanel, BorderLayout.SOUTH);

        // Initialize grid
        updateGrid(model);

        pack();
        setVisible(true);
    }

    public JButton getStartAndPauseButton() {
        return startAndPauseButton;
    }

    private void updateGrid(GameOfLifeModel environment) {
        gridPanel.removeAll();
        for (int i=0; i<environment.getHeigth(); i++) {
            for (int j=0; j<environment.getWidth(); j++) {
                JLabel cellLabel = new JLabel();
                cellLabel.setPreferredSize(new Dimension(cellSize, cellSize));
                cellLabel.setOpaque(true);
                if (environment.getCell(i, j).isAlive()) {
                    cellLabel.setBackground(Color.BLACK);
                } else {
                    cellLabel.setBackground(Color.WHITE);
                }
                gridPanel.add(cellLabel);
            }
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public void stateChanged(GameOfLifeModel environment) {
        if (countLabel != null) {
            countLabel.setText("generation n°" + environment.getGenerationNumber());
        }
        updateGrid(environment);
    }
}
