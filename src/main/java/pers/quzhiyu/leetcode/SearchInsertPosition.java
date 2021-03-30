package pers.quzhiyu.leetcode;

import java.util.Arrays;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        int i = new SearchInsertPosition().searchInsert(a, 2);
        System.out.println(i);
    }
}
