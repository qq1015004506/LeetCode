package pers.quzhiyu.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            sb.append(A[i]);
        }
        BigInteger n = new BigInteger(sb.toString());
        BigInteger add = n.add(new BigInteger(K + ""));
        char[] s = add.toString().toCharArray();
        for (int i = 0; i < s.length; i++) {
            result.add(s[i]-'0');
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};

        new AddToArrayFormOfInteger().addToArrayForm(input,1);
    }
}
