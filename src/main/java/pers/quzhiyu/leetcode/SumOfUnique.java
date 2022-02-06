package pers.quzhiyu.leetcode;

public class SumOfUnique {
    public int sumOfUnique(int[] nums) {
        int res = 0;
        int[] arr = new int[101];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                res+=i;
            }
        }
        return res;
    }
}
