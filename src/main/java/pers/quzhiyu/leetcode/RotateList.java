package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        ListNode tail = cur;
        int n = len - k % len;
        cur = head;
        for (int i = 0; i < n-1; i++) {
            cur = cur.next;
        }
        tail.next = head;
        head = cur.next;
        cur.next = null;
        return head;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        new RotateList().rotateRight(listNode,3);
    }
}
