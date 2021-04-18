package pers.quzhiyu.weekly.weekly237;

import java.util.ArrayList;
import java.util.List;

public class FindXORSumOfAllPairsBitwiseAnd {
    public int getXORSum(int[] arr1, int[] arr2) {
        int res1 = 0, res2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            res1 ^= arr1[i];
        }

        for (int j = 0; j < arr2.length; j++) {
            res2 ^= arr2[j];
        }
        return res1 & res2;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3}, arr2 = {6,5};
    }
}
