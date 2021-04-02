package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.TreeNode;

public class DistributeCoinsInBinaryTree {
    int result = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        int n = root.val;
        result += Math.abs(left) + Math.abs(right) + n - 1;
        return left + right + n - 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(0);
        treeNode.left.right = new TreeNode(3);
        int i = new DistributeCoinsInBinaryTree().distributeCoins(treeNode);
        System.out.println(i);
    }
}
