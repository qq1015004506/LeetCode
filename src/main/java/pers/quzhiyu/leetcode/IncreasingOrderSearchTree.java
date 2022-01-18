package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.TreeNode;

public class IncreasingOrderSearchTree {

    TreeNode head = new TreeNode(0);
    TreeNode cur = head;
    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return head.right;
    }

    private void helper(TreeNode root) {
        if(root == null)
            return;
        helper(root.left);
        cur.right = new TreeNode(root.val);
        cur = cur.right;
        helper(root.right);
    }

}
