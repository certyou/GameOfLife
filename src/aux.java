public class aux {
    public static void main(String args[]) {
        int x = 3;
        int y = 6;
        int[][] test = new int[3][6];
        for (int i=0; i<x; i++) {
            for (int j=0; j<y; j++) {
                test[i][j] = 4*(i+1)*(j+1)/3;
                System.out.print(test[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
