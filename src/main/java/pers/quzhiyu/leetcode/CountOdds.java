package pers.quzhiyu.leetcode;

public class CountOdds {
    public int countOdds(int low, int high) {
        low = low % 2 == 1 ? low - 1 : low;
        high = high % 2 == 1 ? high + 1 : high;
        return (high - low) / 2;
    }

}
