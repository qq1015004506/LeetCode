package pers.quzhiyu.leetcode;

import java.util.Arrays;

public class CountGoodRectangles {
    public int countGoodRectangles(int[][] rectangles) {
        int result = 0;
        int max = 0;
        int[] count = new int[rectangles.length];
        for (int i = 0; i < rectangles.length; i++) {
            count[i] = Math.min(rectangles[i][0], rectangles[i][1]);
            max = Math.max(count[i],max);
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i] == max) {
                result++;
            }
        }
        return result;
    }

}
