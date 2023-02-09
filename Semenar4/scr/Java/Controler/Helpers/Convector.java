package Semenar4.scr.Java.Controler.Helpers;


import java.util.ArrayList;
import java.util.List;

import Semenar4.scr.Java.View.Matrix;

public class Convector implements IArrayToMatrixConvertor, IMatrixToArrayConvertor {

    @Override
    public double[][] matrixToArray(Matrix m) {
        double [][] result = new double [m.rows][m.cols];
        for (int row = 0; row < m.rows; row++){
            for(int col = 0; col < m.cols; col++){
                result[row][col] = m.data.get(row).get(col);
            }
        }
        return result;
    }

    @Override
    public Matrix ArrayToMatrix(double[][] p) {
       Matrix m = new Matrix();
        m.rows = p.length;
        m.cols = p[0].length;
        m.data = new ArrayList<List<Double>>();
        
        for (int row = 0; row < m.rows; row++){
            List<Double> curent = new ArrayList<Double>();
            m.data.add(curent);
            for(int col = 0; col < m.cols; col++){
                curent.add(p[row][col]);
           }
        }
        return m;
    }
}
