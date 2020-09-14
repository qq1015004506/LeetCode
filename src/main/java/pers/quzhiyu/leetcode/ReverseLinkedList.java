package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;


public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode c = head;
        while (c != null) {
            deque.push(c);
            c = c.next;
        }
        head = deque.pop();
        c = head;
        while (!deque.isEmpty()){
            c.next = deque.pop();
            c = c.next;
        }
        c.next = null;
        return head;
    }
}
