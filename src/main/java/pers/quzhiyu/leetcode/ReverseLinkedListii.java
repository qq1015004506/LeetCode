package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseLinkedListii {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;
        for (int i = 0; i < left-1; i++) {
            cur = cur.next;
        }
        ListNode it = cur;
        it = it.next;
        Deque<ListNode> queue = new LinkedList<>();
        int cnt = right - left + 1;
        for (int i = 0; i < cnt; i++) {
            queue.addFirst(it);
            it = it.next;
        }

        while (!queue.isEmpty()) {
            cur.next = queue.removeFirst();
            cur = cur.next;
        }

        cur.next = it;

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode listNode1 = new ReverseLinkedListii().reverseBetween(listNode, 1, 4);
        System.out.println(listNode1);


    }
}
