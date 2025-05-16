package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Grid;
import model.GameOfLifeModel;

public class ModelTest {
    private Grid grid;
    private GameOfLifeModel gameOfLifeModel;

    @BeforeEach
    public void setUp() {
        gameOfLifeModel = new GameOfLifeModel(3,3);
        grid = new Grid(3, 3);
    }

    @Test
    public void testCellBehavior() {
    }

    @Test
    public void testEnvironmentBehavior() {
        assertEquals(3, grid.getWidth(), "Grid width should be 5");
        assertEquals(3, grid.getHeigth(), "Grid height should be 5");
        assertEquals(0, grid.getGenerationNumber(), "Initial generation number should be 0");

        grid.nextGeneration();
        assertEquals(1, grid.getGenerationNumber(), "Generation number should increment after nextGeneration()");
    }

    @Test
    public void testGameOfLifeModel() {
        assertEquals(3, gameOfLifeModel.getWidth(), "Model width should match grid width");
        assertEquals(3, gameOfLifeModel.getHeigth(), "Model height should match grid height");
        assertEquals(0, gameOfLifeModel.getGenerationNumber(), "Initial generation number should be 0");

        gameOfLifeModel.start();
        assertTrue(gameOfLifeModel.isRunning(), "Model should be running after start()");

    }
}
