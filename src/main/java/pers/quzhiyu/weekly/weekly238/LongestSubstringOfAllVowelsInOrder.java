package pers.quzhiyu.weekly.weekly238;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestSubstringOfAllVowelsInOrder {
    public int longestBeautifulSubstring(String word) {
        char[] chars = word.toCharArray();
        if (chars.length<5)return 0;
        int res=0;
        int rlen=1;
        int vowel=1;
        for(int i=1;i<chars.length;i++){
            if(chars[i]>=chars[i-1])rlen++;
            if(chars[i]>chars[i-1])vowel++;
            if(chars[i]<chars[i-1]){rlen=1;vowel=1;}
            if(vowel==5){res=rlen>res?rlen:res;}
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringOfAllVowelsInOrder().longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }
}
