package pers.quzhiyu.leetcode;

import pers.quzhiyu.dataStructure.ListNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null ) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        head = new ListNode(0);
        ListNode t = head;
        for (Integer num : list) {
            t.next = new ListNode(num);
            t = t.next;
        }
        return head.next;
    }
}
