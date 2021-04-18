package pers.quzhiyu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Backtracking {
    /*
    * 假设输入是
    * 2 3
    * 3 2 2 2
    * 5 1 1 9 1 1
    * */
    int cnt = 3 ;
    int[][] input = new int[2][];
    Deque[] deques = new Deque[2];
    static int max = Integer.MIN_VALUE;
    void init() {
        input[0] = new int[] {2,2,3};
        deques[0] = new LinkedList();
        deques[0].add(2);
        deques[0].add(2);
        input[1] = new int[] {1,1,9,1,1};
        deques[1] = new LinkedList();
        deques[1].add(1);
        deques[1].add(1);
        deques[1].add(9);
        deques[1].add(1);
        deques[1].add(1);
    }
    void backtrack() {
        init();
        helper(0,deques,0,0);
        System.out.println(max);
    }
    void helper(int n, Deque[] deques,int result,int index) {
        if(n == cnt) {
            max = Math.max(max,result);
            return;
        }
        for (int i = index; i < input.length * 2; i++) {
            int row = i / 2, col = i % 2;
            Deque deque = deques[row];
            if(deque.size() == 0) {
                continue;
            }
            int num = col == 0 ? (Integer) deque.pollFirst() : (Integer) deque.pollLast();
            helper(n + 1, deques, result + num, i);
            if(col == 0)
                deque.addFirst(num);
            else
                deque.addLast(num);
        }
    }

    public static void main(String[] args) {
        new Backtracking().backtrack();
    }
}
