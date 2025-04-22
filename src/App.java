public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Cell[] cells = {new Cell(), new Cell(), new Cell()};
        cells[0].spawn();
        for (Cell cell : cells) {
            System.out.println(cell);
        }
    }
}
