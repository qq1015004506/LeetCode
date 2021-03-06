package pers.quzhiyu.leetcode;

import java.util.Arrays;

public class HouseRobberii {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return nums[0];
        }
        return Math.max(helper(Arrays.copyOfRange(nums,0,n-1)),helper(Arrays.copyOfRange(nums,1,n)));
    }

    public int helper(int[] nums) {
        int pre = 0, cur = 0, tem = 0;
        for (int num : nums) {
            tem = cur;
            cur = Math.max(cur,pre + num);
            pre = tem;
        }
        return cur;
    }
}
