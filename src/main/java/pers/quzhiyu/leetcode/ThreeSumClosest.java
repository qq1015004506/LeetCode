package pers.quzhiyu.leetcode;

import java.util.Arrays;

/*
    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
    找出 nums 中的三个整数，使得它们的和与 target 最接近。
    返回这三个数的和。假定每组输入只存在唯一答案。

    示例：

    输入：nums = [-1,2,1,-4], target = 1
    输出：2
    解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
*/
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int j = 1 , k = nums.length - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            j = i + 1; k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target)
                    return target;
                if(sum < target) {
                    j++;
                }else {
                    k--;
                }
                int val =  Math.abs(sum - target);
                if(min > val) {
                    result = sum;
                    min = val;
                }
            }
        }

        return result;
    }

}