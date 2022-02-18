package pers.quzhiyu.helper;

import java.util.Arrays;
import java.util.List;

public class TextToDataStructure {
    public static int[] textTo1DArray(String text) {
        text = text.substring(1);
        text = text.substring(0,text.length() - 1);
        int[] res = getArray(text);
        return res;
    }

    private static int[] getArray(String text) {
        String[] split = text.split(",");
        int[] res = new int[split.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt(split[i]);
        }
        return res;
    }

    public static int[][] textTo2DArray(String text) {
        String[] split = text.split("],");
        int[][] res = new int[split.length][];
        for (int i = 0; i < res.length; i++) {
            String s = split[i].replaceAll("\\[","");
            s = s.replaceAll("\\]","");
            res[i] = getArray(s);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] ints = textTo1DArray("[1,2,3,4,5]");
        int[][] int2s = textTo2DArray("[[1,1,1],[1,1,0],[1,0,1]]");
        System.out.println(Arrays.toString(int2s));
    }
}
