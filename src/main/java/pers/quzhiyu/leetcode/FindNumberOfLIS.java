package pers.quzhiyu.leetcode;

public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = 1;
        }
        int max = 0;
        for(int i = 1; i < n; i ++) {
            for(int j =0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    arr[i] = Math.max(arr[j] + 1, arr[i]);
                    max = Math.max(max,arr[i]);
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == max) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,4,7};
        new FindNumberOfLIS().findNumberOfLIS(arr);
    }
}
