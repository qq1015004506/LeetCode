package pers.quzhiyu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k,n,1,new ArrayList<Integer>());
        return result;
    }

    private void helper(int k, int n, int index, ArrayList<Integer> integers) {
        if(k < 0 || n < 0) {
            return;
        }
        if(k == 0 && n == 0) {
            result.add(new ArrayList<Integer>(integers));
            return;
        }

        for (int i = index; i <= 9; i++) {
            integers.add(i);
            helper(k-1,n-i,i + 1, integers);
            integers.remove(integers.size() -1);
        }

    }
}
