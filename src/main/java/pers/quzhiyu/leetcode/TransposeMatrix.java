package pers.quzhiyu.leetcode;

import java.util.Arrays;

public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[n][m];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3},{4,5,6}};

        int[][] transpose = new TransposeMatrix().transpose(matrix);

        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[i].length; j++) {
                System.out.print(transpose[i][j]+" ");
            }
            System.out.println();
        }
    }
}
