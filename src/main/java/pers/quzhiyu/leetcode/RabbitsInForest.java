package pers.quzhiyu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = {1,0,1,0,0};
        int i = new RabbitsInForest().numRabbits(input);
        System.out.println(i);
    }
}
