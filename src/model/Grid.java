package model;

public class Grid {
    private int width;
    private int heigth;
    private double spawnrate;
    private Cell[][] cells;

    public Grid(int x, int y, double spawnrate) {
        this.width = x;
        this.heigth = y;
        this.spawnrate = spawnrate;
        cells = new Cell[y][x];
        double seed;
        for (int i=0; i<heigth; i++) {
            for (int j=0; j<width; j++) {
                seed = Math.random();
                if (seed < spawnrate) {cells[i][j] = new Cell(true);}
                else {cells[i][j] = new Cell(false);}
            }
        }
    }

    public Grid(int x, int y) {
        this(x,y,0.2);
    }

    public int getNumberOfNeighboursAlive(int x, int y) {
        int NumberOfNeighboursAlive = 0;
        for (int dx=-1; dx<=1; dx++) {
            for (int dy=-1; dy<=1; dy++) {
                // check if we are not ouf of range
                if (x+dx>=0 && x+dx<cells[y].length && y+dy>=0 && y+dy<cells.length) {
                    if (cells[x+dx][y+dy].isAlive()) {
                        NumberOfNeighboursAlive++;
                    }
                }
            }
        }
        return NumberOfNeighboursAlive;
    }

    public void nextGeneration() {
        Cell[][] newGen = new Cell[heigth][width];
        for (int i=0; i<heigth; i++) {
            for (int j=0; j<width; j++) {
                // check how many neighbours are alive
                int NumberOfNeighboursAlive = getNumberOfNeighboursAlive(i, j);
                if (NumberOfNeighboursAlive == 3) { // if 3 a new cell appear
                    newGen[i][j] = new Cell(true);
                } else if (cells[i][j].isAlive() && NumberOfNeighboursAlive == 2) { // if 2 cell stay alive
                    newGen[i][j] = new Cell(true);
                } else { // else cell die
                    newGen[i][j] = new Cell(false);
                }
            }
        }
        cells = newGen;
    }

    @Override
    public String toString() {
        String grid = "";
        for (int i=0; i<heigth+2; i++) {
            for (int j=0; j<width+2; j++) {
                if (i==0 || i==heigth+1) {grid += "-";}
                else if (j==0 || j==width+1) {grid += "|";}
                else {
                    grid += cells[i-1][j-1].toString();
                }
            }
            grid += "\n";
        }
        return grid;
    }
}
