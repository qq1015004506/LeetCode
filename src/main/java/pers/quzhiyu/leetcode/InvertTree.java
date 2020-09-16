package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.TreeNode;

public class InvertTree {
    public void helper(TreeNode root) {
        if(root == null)
            return;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        helper(root.left);
        helper(root.right);

    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        helper(root);
        return root;
    }
}
