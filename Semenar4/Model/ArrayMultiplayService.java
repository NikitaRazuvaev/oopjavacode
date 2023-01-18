package Semenar4.Model;

public class ArrayMultiplayService implements IArrayMultiplayService{

    public  double[][] multiply(double[][] a, double[][] b) {
            double[][] result = new double [a.length][b[0].length];
            int n = b.length;
            for (int row = 0; row < a.length ; row++) {
                for (int col = 0; col < b[0].length; col++) {
                    result[row][col] = calcSingleValue(row, col,n,a,b );
                }
            }
            return result;
        }

        private  int calcSingleValue(int row, int col,int n,double[][] a ,double[][] b) {
            int c = 0;
            for (int i = 0; i < n; i++) {
                c += a[row][i] * b[i][col];
            }
            return c;
        }
}
