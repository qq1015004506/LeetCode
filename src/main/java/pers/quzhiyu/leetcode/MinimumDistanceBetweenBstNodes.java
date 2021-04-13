package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumDistanceBetweenBstNodes {
    List<Integer> arr = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        helper(root);
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            int n = arr.get(i) - arr.get(i - 1);
            min = n < min ? n : min;
        }
        return min;
    }

    private void helper(TreeNode root) {
        if(root == null){
            return;
        }
        arr.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
