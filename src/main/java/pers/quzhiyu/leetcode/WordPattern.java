package pers.quzhiyu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] words = s.split(" ");
        Map<String,Character> map1 = new HashMap<>();
        Map<Character,String> map2 = new HashMap<>();
        if(chars.length != words.length) {
            return false;
        }
        for (int i = 0; i < words.length; i++) {
            if(map1.containsKey(words[i]) || map2.containsKey(chars[i])) {
                Character character = map1.get(words[i]);
                String s1 = map2.get(chars[i]);
                if(character != chars[i] || !s1.equals(words[i])) {
                    return false;
                }
            }else {
                map1.put(words[i], chars[i]);
                map2.put(chars[i], words[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = new WordPattern().wordPattern("abba", "dog cat cat fish");
        System.out.println(b);
    }
}
