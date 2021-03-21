package pers.quzhiyu.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    row.add(i); col.add(j);
                }
            }
        }

        for (Integer integer : row) {
            for (int i = 0; i < matrix[integer].length; i++) {
                matrix[integer][i] = 0;
            }
        }

        for (Integer integer : col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][integer] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new SetMatrixZeroes().setZeroes(matrix);
        System.out.println(matrix);
    }
}
