package com.vodopolov.mergeSortedLists;

/**
 * Created by Anton on 16.02.2020.
 */
public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result;
        if (l1 == null && l2 == null) return null;
        if (l1 != null && l2 != null) {
            result = new ListNode(l1.val < l2.val ? l1.val : l2.val);
            result.next = mergeTwoLists(l1.val < l2.val ? l1.next : l1, l1.val < l2.val ? l2 : l2.next);
        } else if (l1 != null) {
            result = l1;
        } else {
            result = l2;
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
