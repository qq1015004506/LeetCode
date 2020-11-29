package pers.quzhiyu.leetcode;

public class IncreasingDecreasingString {

    public String sortString(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i] -'a']++;
        }
        boolean finish = false;
        StringBuilder sb = new StringBuilder();
        while (!finish) {
            finish = true;
            for (int i = 0; i <26; i++) {
                if(arr[i] > 0) {
                    arr[i]--;
                    sb.append((char)('a' + i));
                    finish = false;
                }
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                if(arr[i] > 0) {
                    arr[i]--;
                    sb.append((char)('a' + i));
                    finish = false;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String aaaabbbbcccc = new IncreasingDecreasingString().sortString("aaaabbbbcccc");
        System.out.println(aaaabbbbcccc);
    }
}
