package pers.quzhiyu.leetcode;

import java.util.Arrays;

public class MaximumElementAfterDecrementingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int result = 1;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > result) {
                result++;
            }
        }
        return Math.min(result,arr.length);
    }

    public static void main(String[] args) {
        System.out.println(new MaximumElementAfterDecrementingAndRearranging().maximumElementAfterDecrementingAndRearranging(
                new int[]{73,98,9}
        ));
    }
}
