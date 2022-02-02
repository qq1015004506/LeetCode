package pers.quzhiyu.leetcode;

public class ReversePrefix {
    public static String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        if(i == -1) {
            return word;
        }
        char[] chars = word.toCharArray();

        for (int j = 0; j <= i/2; j++) {
            char t = chars[i- j];
            chars[i - j] = chars[j];
            chars[j] = t;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
        System.out.println(reversePrefix("xyxzxe", 'z'));
        System.out.println(reversePrefix("abcd", 'z'));
        System.out.println(reversePrefix("abcd", 'a'));
        System.out.println(reversePrefix("abcd", 'd'));
    }
}
