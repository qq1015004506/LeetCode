package pers.quzhiyu.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<String> deque = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            int a = 0, b = 0;
            switch (tokens[i]) {
                case "+":
                    a = Integer.valueOf(deque.pollFirst());
                    b = Integer.valueOf(deque.pollFirst());
                    deque.addFirst(String.valueOf(a + b));
                    break;
                case "-":
                    a = Integer.valueOf(deque.pollFirst());
                    b = Integer.valueOf(deque.pollFirst());
                    deque.addFirst(String.valueOf(b - a));
                    break;
                case "*":
                    a = Integer.valueOf(deque.pollFirst());
                    b = Integer.valueOf(deque.pollFirst());
                    deque.addFirst(String.valueOf(b * a));
                    break;
                case "/":
                    a = Integer.valueOf(deque.pollFirst());
                    b = Integer.valueOf(deque.pollFirst());
                    deque.addFirst(String.valueOf(b / a));
                    break;
                default:
                    deque.addFirst(tokens[i]);
                    break;
            }
        }
        return Integer.valueOf(deque.pollFirst());
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int i = new EvaluateReversePolishNotation().evalRPN(tokens);
        System.out.println(i);
    }
}
