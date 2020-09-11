package pers.quzhiyu.leetcode;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] arr = new int[m+1][n+1];
        arr[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = obstacleGrid[i-1][j-1] == 1 ? 0 : arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m][n];
    }
}
