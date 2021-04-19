package pers.quzhiyu.leetcode;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] input = {0,1,2,2,3,0,4,2};
        new RemoveElement().removeElement(input,2);
    }
}
