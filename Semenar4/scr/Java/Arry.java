package Semenar4.scr.Java;

public class Arry {
    public static class MatrixMultiplayer{
        private double[][] a, b, result;
        private int n;
        public MatrixMultiplayer(double [][] a, double[][] b) {
            this.a = a;
            this.b = b;
            this.n = b.length;
            this.result = new double [a.length][b[0].length];
        }
        
        public double[][] run() {
           for (int row = 0; row < a.length ; row++) {
                for (int col = 0; col < b[0].length; col++) {
                    result[row][col] = calcSingleValue(row, col);
                }
            }
            return result;
        }
        private int calcSingleValue(int row, int col) {
            int c = 0;
            for (int i = 0; i < n; i++) {
                c += a[row][i] * b[i][col];
            }
            return c;
        }
    }
    public static double[][] multiply(double[][] a, double[][] b) {
        //проверки
        if (a == null || a.length == 0 || a[0] == null || a[0].length == 0) {
            throw new IllegalArgumentException("a");
        }
        if (b == null || b.length == 0 || b[0] == null || b[0].length == 0) {
            throw new IllegalArgumentException("b");
        }
        if (a[0].length != b.length) {
            throw new IllegalArgumentException("матрицы не согласованы");
        }    

        MatrixMultiplayer multiplayer = new MatrixMultiplayer(a, b);
        return multiplayer.run();
    }
    public static void main(String[] args) {
        double[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        double[][] b = {{2, 1, 2, 1, 2, 1, 2}, {1, 2, 1, 2, 1, 2, 1}, {2, 1, 2, 1, 2, 1, 2}, {1, 2, 1, 2, 1, 2, 1}};
        double[][] c = multiply(a, b);
        for (double[] row : c) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
