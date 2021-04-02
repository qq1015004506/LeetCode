package pers.quzhiyu.leetcode;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
