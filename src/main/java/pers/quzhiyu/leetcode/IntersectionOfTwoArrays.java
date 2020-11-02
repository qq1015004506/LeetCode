package pers.quzhiyu.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int l1 = nums1.length, l2 = nums2.length;
        Set<Integer> set = new HashSet<>();
        while (i < l1 && j < l2) {
            if(nums1[i] < nums2[j]) {
                i++;
                continue;
            }
            if(nums1[i] > nums2[j]) {
                j++;
                continue;
            }
            if(nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;j++;
            }
        }
        int[] res = new int[set.size()];
        int k= 0;
        for (Integer integer : set) {
            res[k++] = integer;
        }
        return res;
    }
}
