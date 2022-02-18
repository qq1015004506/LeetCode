package pers.quzhiyu.leetcode;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j =0; j<n;j++)
            {
                if (grid[i][j]=='1') {
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    void dfs(char[][] grid, int i, int j){
        if(i<0 || j <0 || i>=grid.length || j>= grid[0].length) return;
        if (grid[i][j]=='0') return;
        else grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        dfs(grid,i+1,j);
        return;
    }
}
