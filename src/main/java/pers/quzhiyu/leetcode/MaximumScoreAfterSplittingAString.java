package pers.quzhiyu.leetcode;

public class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length-1; i++) {
            int score1 = 0;
            int score2 = 0;
            for (int j = i; j >= 0; j--) {
                if(chars[j] == '0'){
                    score1++;
                }
            }
            for (int j = i+1; j < chars.length; j++) {
                if(chars[j] == '1') {
                    score2++;
                }
            }
            result  = Math.max(score1 + score2,result);
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "00";
        int i = new MaximumScoreAfterSplittingAString().maxScore(str);
        System.out.println(i);
    }
}
