package pers.quzhiyu.leetcode;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
                index++;
            }
        }
    }


}
