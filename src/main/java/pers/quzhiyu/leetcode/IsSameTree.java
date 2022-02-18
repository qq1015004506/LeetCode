package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.TreeNode;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p!= null && q != null) {
            if (p.val != q.val)
                return false;
            else
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }

        return false;
    }
}
