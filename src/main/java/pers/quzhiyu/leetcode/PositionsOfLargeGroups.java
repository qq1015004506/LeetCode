package pers.quzhiyu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        char[] chars = s.toCharArray();

        int left = 0, right = 1;
        char c = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if(c == chars[i]) {
                right++;
            }else {
                if(right - left > 2) {
                    result.add(Arrays.asList(left,right-1));
                }
                left = right++;
                c = chars[i];
            }
        }
        if(right - left > 2) {
            result.add(Arrays.asList(left,right-1));
        }
        return result;
    }

}
