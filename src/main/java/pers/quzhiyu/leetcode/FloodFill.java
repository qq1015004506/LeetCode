package pers.quzhiyu.leetcode;

import pers.quzhiyu.helper.TextToDataStructure;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;
        helper(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }

    private void helper(int[][] image, int sr, int sc, int newColor,int oldColor) {
        int r = image.length, c = image[0].length;
        if(sr < 0 || sc < 0 || sr >= r || sc >= c) {
            return;
        }
        if(image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            helper(image,sr-1,sc,newColor,oldColor);
            helper(image,sr+1,sc,newColor,oldColor);
            helper(image,sr,sc-1,newColor,oldColor);
            helper(image,sr,sc+1,newColor,oldColor);
        }
    }

    public static void main(String[] args) {
        int[][] ints = TextToDataStructure.textTo2DArray("[[0,0,0],[0,1,1]]");
        FloodFill floodFill = new FloodFill();
        int[][] ints1 = floodFill.floodFill(ints, 1, 1, 1);
        System.out.println(ints1);
    }

}
