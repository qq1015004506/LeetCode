package pers.quzhiyu.leetcode;

public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        while (row<matrix.length && target >= matrix[row][0]) {
            row++;
        }
        row--;
        if(row < 0) {
            return false;
        }
        for (int i = 0; i < matrix[row].length; i++) {
            if(matrix[row][i] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix1 = {{1}};
        System.out.println(new SearchA2dMatrix().searchMatrix(matrix1,1));
    }
}
