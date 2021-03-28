package pers.quzhiyu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        List<Integer> rowMin = new ArrayList<>();
        List<Integer> colMax = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                min = min > matrix[i][j] ? matrix[i][j] : min;
            }
            rowMin.add(min);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                max = max < matrix[j][i] ? matrix[j][i] : max;
            }
            colMax.add(max);
        }

        for (Integer max : colMax) {
            if(rowMin.contains(max)) {
                result.add(max);
            }
        }
        
        return result;
    }

}
