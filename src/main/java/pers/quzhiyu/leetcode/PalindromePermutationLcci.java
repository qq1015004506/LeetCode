package pers.quzhiyu.leetcode;

public class PalindromePermutationLcci {
    public boolean canPermutePalindrome(String s) {
        char[] arr = new char[256];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i]]++;
        }
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 1) {
                cnt ++;
            }
        }
        return cnt < 2;
    }
}
