package pers.quzhiyu.leetcode;

import java.util.Arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int result = -1;
        int left = 0, right = 0;
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }
        if(right == 0)
            return 0;
        for (int i = 1; i < nums.length; i++) {
            right -= nums[i];
            left += nums[i-1];
            if(left == right) {
                return i;
            }
        }
        return result;
    }
}
