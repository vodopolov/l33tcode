package com.vodopolov.mergeSortedLists;

/**
 * Created by Anton on 16.02.2020.
 */
public class MergeSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return new ListNode(0);
    }

    private ListNode result;
    private ListNode lastNode;

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return result;
        if (l1 == null) {
            result.next = l2;
            mergeTwoLists(null, l2);
        } else if (l2 == null) {
            result.next = l1;
            mergeTwoLists(l1.next, null);
        } else {
            if (l1.val >= l2.val) {
                helper(l1, l2);
            } else {
                helper(l2, l1);
            }
        }
        return result;
    }

    private void helper(ListNode nodeToAdd, ListNode nodeToPass) {
        ListNode node = new ListNode(nodeToAdd.val);
        if (result == null) result = node;
        else if (result.next == null) {
            lastNode = node;
            result.next = lastNode;
        }
        else {
            lastNode.next = node;
            lastNode = node;
        }
        mergeTwoLists(nodeToPass, nodeToAdd.next);
    }
}
