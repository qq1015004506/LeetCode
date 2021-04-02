package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedListii {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        if(head.val==head.next.val){
            while (head!=null && head.next!=null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next.next = new ListNode(5);
        new RemoveDuplicatesFromSortedListii().deleteDuplicates(listNode);
    }
}
