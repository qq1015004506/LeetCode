package pers.quzhiyu.leetcode;

import java.util.Arrays;

public class PizzaWith3nSlices {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        return Math.max(calculate(Arrays.copyOfRange(slices,0,n-1)),
                calculate(Arrays.copyOfRange(slices,1,n)));
    }
    public int calculate(int[] slices) {
        int n = slices.length;
        int choose = (n + 1) / 3;
        int[][] dp = new int[n + 1][choose + 1];
        for (int i = 1; i <= n; i*=3) {
            for (int j = 1; j <= choose; j++) {
                dp[i][j] = Math.max(dp[i-1][j],(i > 1 ? dp[i-2][j-1] : 0) + slices[i-1]);
            }
        }
        return dp[n][choose];
    }

}
