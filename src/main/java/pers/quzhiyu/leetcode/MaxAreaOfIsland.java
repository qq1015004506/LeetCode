package pers.quzhiyu.leetcode;

import pers.quzhiyu.helper.TextToDataStructure;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int num = helper(grid,i,j);
                    max = Math.max(max,num);
                }
            }
        }
        return max;
    }

    private int helper(int[][] grid, int i, int j) {
        int res = 0;
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return res;
        }
        if(grid[i][j] == 1) {
            res ++;
            grid[i][j] = 0;
            return res +
                    helper(grid, i+1, j)+
                    helper(grid, i-1, j)+
                    helper(grid, i, j+1)+
                    helper(grid, i, j-1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = TextToDataStructure.textTo2DArray("[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]");
        new MaxAreaOfIsland().maxAreaOfIsland(ints);
    }
}
