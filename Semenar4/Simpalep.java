package Semenar4;

import Semenar2.demo;

public class Simpalep {
    
    double [][] firstMat = {
        new double[]{1d, 5d},
        new double[]{2d,3d},
        new double[]{1d,7d}
    };
    double [][] secondMat = {
        new double[]{1d,2d,3d,7d};
        new double[]{5d,2d,8d,7d};
    };
    double[][] multiplyMatrices(double[][] firstMat, double[][] secondMat) {
        double[][] result = new double[firstMat.length][secondMat[0].length];
    
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMat, secondMat, row, col);
            }
        }
    
        return result;
    }
    double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }
    double[][] actual = multiplyMatrices(firstMat, secondMat);
    assertThat(actual).isEqualTo(expected);
}
