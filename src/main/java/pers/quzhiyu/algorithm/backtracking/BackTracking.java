package pers.quzhiyu.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking {
    List<List<Integer>> result = new ArrayList<>();

    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int m;
    private int n;
    private String word;
    private char[][] board;
    private boolean[][] isVisited;
    // 一维回溯 ：

    // 回溯模板：
    // leetcode 例题：17.电话号码的字母组合, 40.组合总和 II, 46.全排列, 131.分割回文串
    // 假设我们有个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
    //
    // 情况一：
    // 有重复，[不需要去重]，每个元素[只取一次]
    // candidates: [10,1,2,7,6,1,5] target:8
    // 最终结果：[[1, 2, 5], [1, 7], [1, 6, 1], [2, 6], [2, 1, 5], [7, 1]]
    public List<List<Integer>> situationOne(int[] candidates, int target) {
        situationOneHelper(candidates,target,0,new ArrayList<Integer>());
        return result;
    }
    private void situationOneHelper(int[] candidates, int target, int index, ArrayList<Integer> res) {
        if(target < 0) return;
        if(target == 0) {
            // 因为是地址引用所以需要再复制一份
            result.add(new ArrayList<Integer>(res));
            return;
        }
        // 对数组进行遍历
        for (int i = index; i < candidates.length; i++) {
            res.add(candidates[i]);
            // index 参数为i + 1 表示每个元素只去一次
            situationOneHelper(candidates,target - candidates[i],i + 1, res);
            res.remove(res.size() -1);
        }
    }

    // 情况二：
    // 无重复，每个元素取多次
    // candidates: [10,1,2,7,6,5] target:8
    // result： [[1, 1, 1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1, 2], [1, 1, 1, 1, 2, 2], [1, 1, 1, 5], [1, 1, 2, 2, 2], [1, 1, 6], [1, 2, 5], [1, 7], [2, 2, 2, 2], [2, 6]]
    public List<List<Integer>> situationTwo(int[] candidates, int target) {
        situationTwoHelper(candidates,target,0,new ArrayList<Integer>());
        return result;
    }
    private void situationTwoHelper(int[] candidates, int target, int index, ArrayList<Integer> res) {
        if(target < 0) return;
        if(target == 0) {
            // 因为是地址引用所以需要再复制一份
            result.add(new ArrayList<Integer>(res));
            return;
        }
        // 对数组进行遍历
        for (int i = index; i < candidates.length; i++) {
            res.add(candidates[i]);
            // 因为可以重复选择，因此index不需要增加
            situationTwoHelper(candidates,target - candidates[i],i, res);
            res.remove(res.size() -1);
        }
    }
    // 情况三：
    // 有重复，需要去重，每个元素取一次
    // candidates: [10,1,2,7,6,1,5] target:8
    // result: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
    public List<List<Integer>> situationThree(int[] candidates, int target) {
        Arrays.sort(candidates);
        situationThreeHelper(candidates,target,0,new ArrayList<Integer>());
        return result;
    }
    private void situationThreeHelper(int[] candidates, int target, int index, ArrayList<Integer> res) {
        if(target < 0) return;
        if(target == 0) {
            // 因为是地址引用所以需要再复制一份
            result.add(new ArrayList<Integer>(res));
            return;
        }
        // 对数组进行遍历
        for (int i = index; i < candidates.length; i++) {
            // 当i == index 时说明是第一次被选中
            if(i != index && candidates[i] == candidates[i-1]) continue;
            res.add(candidates[i]);
            // 因为每个元素取一次，因此index + 1
            situationThreeHelper(candidates,target - candidates[i],i+1, res);
            res.remove(res.size() -1);
        }
    }
    // 情况四：
    // 无重复，每个元素取一次
    // candidates: [10,1,2,7,6,5] target:8
    public List<List<Integer>> situationFour(int[] candidates, int target) {
        situationFour(candidates,target,0,new ArrayList<Integer>());
        return result;
    }
    private void situationFour(int[] candidates, int target, int index, ArrayList<Integer> res) {
        if(target < 0) return;
        if(target == 0) {
            // 因为是地址引用所以需要再复制一份
            result.add(new ArrayList<Integer>(res));
            return;
        }
        // 对数组进行遍历
        for (int i = index; i < candidates.length; i++) {
            res.add(candidates[i]);
            // 因为每个元素取一次，因此index + 1
            situationFour(candidates,target - candidates[i],i+1, res);
            res.remove(res.size() -1);
        }
    }

    // 二维回溯：
    // 回溯类型（需要重置状态）
    // 79 单词搜索：
    // 这道题属于 需要改变状态的深度搜索：
    // 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
    // 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        isVisited = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            // 因为不允许重复使用，所以我们需要记录单词的使用状态
            isVisited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (isValid(newX, newY) && !isVisited[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            // 因为每次外层的for循环访问都需要重新记录（单词的新起点）
            // 因此每次回退时需要将其复位
            isVisited[i][j] = false;
        }
        return false;
    }
    // flood fill 算法（不需要重置状态）
    // 200. 岛屿数量
    // 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    //
    // 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
    //
    // 此外，你可以假设该网格的四条边均被水包围。

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]) {
                    // 要统计岛的个数，因此每次循环只要当前格子是岛并且没有访问过说明是一个新岛
                    // 因为一旦执行helper之后相连的岛的格子都会被标记访问过
                    // 因此 result + 1
                    result++;
                    helper(grid,i,j);
                }
            }
        }
        return result;
    }

    private void helper(char[][] grid, int i, int j) {
        if (isValid(i, j) && grid[i][j] == '1' && !isVisited[i][j]) {
            isVisited[i][j] = true;
            helper(grid, i, j + 1);
            helper(grid, i, j - 1);
            helper(grid, i + 1, j);
            helper(grid, i - 1, j);
        }
    }

    private boolean isValid(int i, int j) {
        return !(i < 0 || i >= m || j < 0 || j >= n);
    }

}
