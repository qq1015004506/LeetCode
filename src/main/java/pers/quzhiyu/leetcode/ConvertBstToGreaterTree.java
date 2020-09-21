package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertBstToGreaterTree {
    int sum = 0;
    public TreeNode convertBstToGreaterTree(TreeNode root) {
        if (root != null) {
            convertBstToGreaterTree(root.right);
            sum += root.val;
            root.val = sum;
            convertBstToGreaterTree(root.left);
        }
        return root;
    }
}
