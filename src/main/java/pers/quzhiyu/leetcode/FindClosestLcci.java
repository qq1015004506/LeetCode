package pers.quzhiyu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindClosestLcci {
    public int findClosest(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        List<Integer> arr1 = new ArrayList<>(words.length);
        List<Integer> arr2 = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                arr1.add(i);
            }
            if(words[i].equals(word2)) {
                arr2.add(i);
            }
        }

        int n1 = arr1.size()-1, n2 = arr2.size()-1;
        while (n1 >= 0 && n2 >=0) {
            int val = Math.abs(arr1.get(n1) - arr2.get(n2));
            result = result < val ? result : val;
            if(arr1.get(n1) > arr2.get(n2)) {
                n1--;
            }else {
                n2--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"I","am","a","student","from","a","university","in","a","city"};
        new FindClosestLcci().findClosest(arr,"a","student");
    }
}
