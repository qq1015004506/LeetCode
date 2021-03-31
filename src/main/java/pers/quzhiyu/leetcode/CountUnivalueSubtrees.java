package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.TreeNode;
import sun.reflect.generics.tree.Tree;

public class CountUnivalueSubtrees {

    int result = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return result;
    }
    boolean helper(TreeNode node) {
        if(node == null) {
            return true;
        }
        if(node.left == null && node.right == null) {
            result++;
            return true;
        }

        boolean left = helper(node.left) && (node.left == null || node.left.val == node.val);
        boolean right = helper(node.right) && (node.right == null || node.right.val == node.val);
        if(left && right) {
            result++;
        }
        return left && right;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(5);
        new CountUnivalueSubtrees().helper(node);
    }
}
