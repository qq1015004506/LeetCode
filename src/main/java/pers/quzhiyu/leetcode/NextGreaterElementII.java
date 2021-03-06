package pers.quzhiyu.leetcode;

import java.util.Arrays;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n * 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i%n];
        }
        int[] result = new int[n];
        Arrays.fill(result,-1);
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                if(nums[i] < arr[j]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }
}
