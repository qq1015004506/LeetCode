package pers.quzhiyu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSumii {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map1 = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int val = A[i]+B[j];
                if(map1.containsKey(val)) {
                    map1.put(val,map1.get(val)+1);
                }else {
                    map1.put(val,1);
                }
            }
        }
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int val = C[i]+D[j];
                if(map2.containsKey(val)) {
                    map2.put(val,map2.get(val)+1);
                }else {
                    map2.put(val,1);
                }
            }
        }
        int result = 0;
        for (Integer integer : map1.keySet()) {
            if(map2.containsKey(0-integer)) {
                result += map1.get(integer) * map2.get(0-integer);
            }
        }
        return result;
    }
}
