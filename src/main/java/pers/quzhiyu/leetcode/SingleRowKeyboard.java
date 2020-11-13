package pers.quzhiyu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        char[] chars = keyboard.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],i);
        }
        char[] words = word.toCharArray();
        int count = 0;
        int cur = map.get(words[0]);
        count += cur;
        for (int i = 1; i < words.length; i++) {
            int t = map.get(words[i]);
            count += Math.abs(cur-t);
            cur = t;
        }
        return count;
    }
}
