package pers.quzhiyu.weekly.weekly237;

public class checkIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        int[] alpha = new int[26];
        char[] chars = sentence.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            alpha[chars[i]-'a'] ++;
        }
        for (int i = 0; i < alpha.length; i++) {
            if(alpha[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
