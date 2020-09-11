package pers.quzhiyu.leetcode;

import java.util.HashSet;
import java.util.Set;

public class KEmptySlots {
    public int kEmptySlots(int[] bulbs, int K) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < bulbs.length; i++) {
            if(set.contains(bulbs[i] - K - 1) || set.contains(bulbs[i] + K + 1)) {
                boolean has1 = false;
                boolean has2 = false;
                for (int j = bulbs[i] - K - 1; j <= bulbs[i]; j++) {
                    if(set.contains(j)) {
                        has1 = true;
                        break;
                    }
                }
                for (int j = bulbs[i]; j <= bulbs[i] + K + 1; j++) {
                    if(set.contains(j)) {
                        has2 = true;
                        break;
                    }
                }
                if(has1 && has2) {
                    break;
                }
                return i+1;
            }else {
                set.add(bulbs[i]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new KEmptySlots().kEmptySlots(new int[]{1,2,3},1);
    }
}
