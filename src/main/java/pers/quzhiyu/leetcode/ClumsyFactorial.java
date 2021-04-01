package pers.quzhiyu.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ClumsyFactorial {
    public int clumsy(int N) {
        int num[] = {1, 2, 2, -1};
        return N > 4 ? N + num[N % 4] : (N > 2 ? N + 3 : N);
    }

    public static void main(String[] args) {

    }



}
