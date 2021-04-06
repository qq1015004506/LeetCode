package pers.quzhiyu.leetcode;

import java.util.Arrays;

public class PurchasePlans {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i >= target) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] <= target) {
                    res++;
                }
            }
        }
        return res % 1000000007;
    }

    public static void main(String[] args) {
        int[] input = {2,5,3,5};
        int i = new PurchasePlans().purchasePlans(input, 6);
        System.out.println(i);
    }
}
