package pers.quzhiyu.leetcode;

import java.util.Arrays;

public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if(n > nums[j]) {
                    int m = nums[j];
                    for (int k = i-1; k >= 0; k--) {
                        if(m > nums[k]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-1,3,2,0};
        new OneThreeTwoPattern().find132pattern(arr);
    }
}
