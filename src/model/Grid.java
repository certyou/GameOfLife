package model;

public class Grid {
    private int x;
    private int y;
    private Cell[][] cells;

    public Grid(int x, int y, double spawnrate) {
        this.x = x;
        this.y = y;
        cells = new Cell[y][x];
        double seed;
        for (int i=0; i<y; i++) {
            for (int j=0; j<x; j++) {
                seed = Math.random();
                if (seed < spawnrate) {cells[i][j] = new Cell(true);}
                else {cells[i][j] = new Cell(false);}
            }
        }
    }

    public Grid(int x, int y) {
        this(x,y,0.2);
    }

    @Override
    public String toString() {
        String grid = "";
        for (int i=0; i<y+2; i++) {
            for (int j=0; j<x+2; j++) {
                if (i==0 || i==y+1) {grid += "-";}
                else if (j==0 || j==x+1) {grid += "|";}
                else {
                    grid += cells[i-1][j-1].toString();
                }
            }
            grid += "\n";
        }
        return grid;
    }
}
