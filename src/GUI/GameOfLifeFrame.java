package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.Subscriber;

import controller.EnvironmentController;
import model.Environment;

public class GameOfLifeFrame extends JFrame implements Subscriber {
    private JPanel gridPanel;
    private int cellSize = 10;

    public GameOfLifeFrame(EnvironmentController environmentController) {
        environmentController.add(this);

        setTitle("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

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
        /* 
         * Thread evolveThread = new Thread(() -> System.exit(0));
                evolveThread.start();
        */
        startButton.addActionListener(
            (ActionEvent e) -> {
                environmentController.play();
        });

        stopButton.addActionListener(
            (ActionEvent e) -> {
                environmentController.stop();
        });

        // Initialize grid
        updateGrid(environmentController.getEnvironment());

        pack();
        setVisible(true);
    }

    private void updateGrid(Environment environment) {
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

    public void stateChanged(Environment environment) {
        updateGrid(environment);
    }
}
