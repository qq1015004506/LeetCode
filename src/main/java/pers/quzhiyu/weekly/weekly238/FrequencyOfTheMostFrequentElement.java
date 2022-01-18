package pers.quzhiyu.weekly.weekly238;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;
        for (int r = 1; r < n; ++r){
            total += (long)(nums[r] - nums[r - 1]) * (r - l);
            while (total > k){
                total -= nums[r] - nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2,4};
        int[] input1 = new int[] {1,4,8,13};
        int[] input2 = new int[] {3,9,6};
        System.out.println(new FrequencyOfTheMostFrequentElement().maxFrequency(input1, 5));
    }
}
