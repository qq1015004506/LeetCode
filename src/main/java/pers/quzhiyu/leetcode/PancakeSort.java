package pers.quzhiyu.leetcode;

import pers.quzhiyu.helper.TextToDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PancakeSort {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int idx = findMax(arr,arr.length - i);
            reverse(arr,0,idx);
            reverse(arr,0,arr.length - i - 1);
            res.add(idx+1);
            res.add(arr.length-i);
        }
        return res;
    }

    private void reverse(int[] arr, int i, int idx) {
        while (i < idx) {
            int t = arr[i];
            arr[i++] = arr[idx];
            arr[idx--] = t;
        }
    }


    private int findMax(int[] arr,int len) {
        int max = 0; int res = 0;
        for (int i = 0; i < len; i++) {
            if(max < arr[i]) {
                max = arr[i];
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = TextToDataStructure.textTo1DArray("[1,4,2,3]");
        new PancakeSort().pancakeSort(ints);
    }
}
