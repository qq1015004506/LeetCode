package pers.quzhiyu.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        Deque<Character> deque = new LinkedList<>();
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(deque.isEmpty()) {
                deque.push(chars[i]);
                continue;
            }
            if(deque.peekFirst() == chars[i]) {
                deque.pop();
            }else {
                deque.push(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int len = deque.size();
        for (int i = 0; i < len; i++) {
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String abbbaca = new RemoveAllAdjacentDuplicatesInString().removeDuplicates("abbbace");
        System.out.println(abbbaca);
    }
}
