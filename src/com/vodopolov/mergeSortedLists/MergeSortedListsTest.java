package com.vodopolov.mergeSortedLists;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Anton on 16.02.2020.
 */
class MergeSortedListsTest {
    @org.junit.jupiter.api.Test
    void mergeKLists() {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node1 = new ListNode(1);
        list.add(node1);
        ListNode node2 = new ListNode(4);
        node1.next = node2;
        ListNode node3 = new ListNode(5);
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        list.add(node4);
        ListNode node5 = new ListNode(3);
        node4.next = node5;
        ListNode node6 = new ListNode(4);
        node5.next = node6;

        ListNode node7 = new ListNode(2);
        list.add(node7);
        ListNode node8 = new ListNode(6);
        node7.next = node8;

        MergeSortedLists inst = new MergeSortedLists();
        ListNode result = inst.mergeKLists((ListNode[]) list.toArray());
    }
}