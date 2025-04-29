import model.Grid;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Grid grid = new Grid(20,10);
        //grid.spawnCell(3,3);
        //grid.spawnCell(4,4);
        //grid.spawnCell(4,5);
        //grid.spawnCell(5,4);
        //grid.spawnCell(5,3);
        for (int n=0; n<15; n++) {
            Thread.sleep(1000);
            System.out.println(grid);
            grid.nextGeneration();
        }
    }
}
