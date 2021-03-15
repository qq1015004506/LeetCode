package pers.quzhiyu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    enum Dir {
        right,
        down,
        left,
        up
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] matrix2 = new int[m+2][n+2];
        for (int i = 0; i <= n+1; i++) {
            matrix2[0][i] = 1;
            matrix2[m+1][i] = 1;
        }
        for (int i = 0; i <= m+1; i++) {
            matrix2[i][0] = 1;
            matrix2[i][n+1] = 1;
        }
        List<Integer> result = new ArrayList<>();
        int cnt = m * n;
        int i = 0;
        int row = 1;
        int col = 1;
        Dir d = Dir.right;
        while (i < cnt) {
            result.add(matrix[row-1][col-1]);
            matrix2[row][col] = 1;
            if(d == Dir.right ) {
               if( matrix2[row][col+1] != 1){
                   col++;
               }else {
                   d = Dir.down;
                   row++;
               }
            }else if( d == Dir.down) {
                if( matrix2[row+1][col] != 1){
                    row++;
                }else {
                    d = Dir.left;
                    col--;
                }
            }else if( d == Dir.left) {
                if(matrix2[row][col-1] != 1){
                    col--;
                }else {
                    d = Dir.up;
                    row--;
                }
            }else if(d == Dir.up) {
                if(matrix2[row-1][col] != 1){
                    row--;
                }else {
                    d = Dir.right;
                    col++;
                }
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        new SpiralMatrix().spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}});
    }
}
