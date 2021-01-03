package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        while (cur != null) {
            int t = cur.val;
            if(t < x)
                arr1.add(t);
            else
                arr2.add(t);
            cur = cur.next;
        }
        ListNode result = new ListNode(0);
        cur = result;
        for (int i = 0; i < arr1.size(); i++) {
            cur.next = new ListNode(arr1.get(i));
            cur = cur.next;
        }
        for (int i = 0; i < arr2.size(); i++) {
            cur.next = new ListNode(arr2.get(i));
            cur = cur.next;
        }
        return result.next;
    }
}
