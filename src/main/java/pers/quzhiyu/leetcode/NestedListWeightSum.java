package pers.quzhiyu.leetcode;

import pers.quzhiyu.helper.NestedInteger;

import java.util.List;

public class NestedListWeightSum {
        public int depthSum(List<NestedInteger> nestedList) {
            int n = helper(nestedList,1);
            return n;
        }

        private int helper(List<NestedInteger> nestedList, int i) {
            int sum = 0;
            for (NestedInteger nestedInteger : nestedList) {
                if(nestedInteger.isInteger()) {
                    sum += i * nestedInteger.getInteger();
                }else {
                    sum += helper(nestedInteger.getList(),i + 1);
                }
            }
            return sum;
        }
}
