package pers.quzhiyu.leetcode;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int m = chars1.length, n = chars2.length;
        int [][] dp = new int[m+1][n+1];
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if(chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String a = "abcdef";
        String b = "ace";
        int i = new LongestCommonSubsequence().longestCommonSubsequence(a, b);
        System.out.println(i);
    }
}
