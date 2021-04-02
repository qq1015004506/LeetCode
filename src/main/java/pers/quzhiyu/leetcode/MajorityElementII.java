package pers.quzhiyu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE,  m = 0, n = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == a) {
                m++;
            }
            if(nums[i] == b) {
                n++;
            }
            if(nums[i] != a && nums[i] != b) {
                if(m == 0) {
                    a = nums[i];
                    m = 1;
                }else if(n == 0) {
                    b = nums[i];
                    n = 1;
                }else {
                    m--; n--;
                }
            }
        }
        m = n = 0;
        for (int num : nums) {
            if (a == num) m++;
            else if (b == num) n++;
        }

        if (m > nums.length / 3) res.add(a);
        if (n > nums.length / 3) res.add(b);
        return res;
    }

    public static void main(String[] args) {
        int[] input = {1,1,1,3,3,2,2,2};
        List<Integer> integers = new MajorityElementII().majorityElement(input);
        System.out.println(integers);
    }
}
