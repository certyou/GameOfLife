package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import controller.Subscriber;
import controller.EnvironmentController;

public class GameOfLifeFrame extends JFrame implements Subscriber {
    private JPanel gridPanel;
    private int cellSize = 10;
    private JLabel countLabel;

    public GameOfLifeFrame(EnvironmentController environmentController) {
        environmentController.add(this);

        setTitle("Game of Life");
        setLayout(new BorderLayout());

        // count generation panel
        JPanel countJPanel = new JPanel();
        countLabel = new JLabel("generation n°" + environmentController.getGenerationNumber());
        countJPanel.add(countLabel);
        add(countJPanel, BorderLayout.NORTH);

        // Create grid panel
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(environmentController.getHeigth(), environmentController.getWidth())); // Adjust grid size as needed
        add(gridPanel, BorderLayout.CENTER);

        // Add control buttons
        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        add(controlPanel, BorderLayout.SOUTH);

        // Add action listeners
        startButton.addActionListener(
            (ActionEvent e) -> {environmentController.play();}
        );

        stopButton.addActionListener(
            (ActionEvent e) -> {environmentController.stop();}
        );

        // Initialize grid
        updateGrid(environmentController);

        pack();
        setVisible(true);
    }

    private void updateGrid(EnvironmentController environment) {
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

    public void stateChanged(EnvironmentController environment) {
        if (countLabel != null) {
            countLabel.setText("generation n°" + environment.getGenerationNumber());
        }
        updateGrid(environment);
    }
}
