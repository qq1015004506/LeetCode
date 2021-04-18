package pers.quzhiyu.weekly.weekly237;

import java.util.Arrays;

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0, acc = 0;
        for (int i = 0; i < costs.length; i++) {
            acc += costs[i];
            if(acc <= coins) {
                res ++;
            }else {
                break;
            }
        }
        return res;
    }
}
