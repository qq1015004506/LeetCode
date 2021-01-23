package pers.quzhiyu.leetcode;

import java.util.*;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        for (int num : nums) {
            arr[num] += num;
        }
        int pre = 0, cur = 0, tmp = 0;
        for (int num : arr) {
            tmp = cur;
            cur = Math.max(pre + num,cur);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,2};
        new DeleteAndEarn().deleteAndEarn(arr);

    }
}
