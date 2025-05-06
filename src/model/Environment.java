package model;

public interface Environment {
    public void nextGeneration();
    public int getGenerationNumber();
    public int getHeigth();
    public int getWidth();
    public Element getCell(int x, int y);
}
