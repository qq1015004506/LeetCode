package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        ListNode head1 = l1,head2 = l2 ;
        while (head1 != null ) {
            deque1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            deque2.push(head2.val);
            head2 = head2.next;
        }
        boolean flag = false;
        ListNode result = new ListNode(0);
        ListNode it = result;
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            int num1 = deque1.removeLast();
            int num2 = deque2.removeLast();
            int num = num1 + num2;
            if(flag) {
                num = num + 1;
                flag = false;
            }
            if(num >= 10) {
                flag = true;
                num = num % 10;
            }
            ListNode listNode = new ListNode(num);
            it.next = listNode;
            it = it.next;
        }
        while (!deque1.isEmpty()) {
            int num = deque1.removeLast();
            if(flag) {
                num = num + 1;
                flag = false;
            }
            if(num >= 10) {
                flag = true;
                num = num % 10;
            }
            ListNode listNode = new ListNode(num);
            it.next = listNode;
            it = it.next;
        }
        while (!deque2.isEmpty()) {
            int num = deque2.removeLast();
            if(flag) {
                num = num + 1;
                flag = false;
            }
            if(num >= 10) {
                flag = true;
                num = num % 10;
            }
            ListNode listNode = new ListNode(num);
            it.next = listNode;
            it = it.next;
        }
        if(flag) {
            ListNode listNode = new ListNode(1);
            it.next = listNode;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(9);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        listNode2.next.next.next = new ListNode(9);
        ListNode listNode = new AddTwoNumbers().addTwoNumbers(listNode1, listNode2);
    }
}
