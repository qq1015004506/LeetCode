package pers.quzhiyu.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int result = 0;
        int[] num = new int[100];
        for (int[] dominoe : dominoes) {
            int n = dominoe[0] < dominoe[1] ? dominoe[0] * 10 + dominoe[1] : dominoe[1] * 10 + dominoe[0];
            result += num[n];
            num[n]++;
        }
        return result;
    }
}
