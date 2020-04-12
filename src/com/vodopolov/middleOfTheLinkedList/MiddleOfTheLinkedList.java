package com.vodopolov.middleOfTheLinkedList;

/**
 * Created by Anton on 12.04.2020.
 */
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        MiddleOfTheLinkedList inst = new MiddleOfTheLinkedList();
        inst.test();
    }

    private void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;

        ListNode middle = middleNode(node1);
        System.out.println(middle.val);
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        return iterate(head, head, false);
    }

    private ListNode iterate(ListNode slowPointer, ListNode fastPointer, boolean isEven) {
        System.out.println(slowPointer.val + " " + fastPointer.val + " " + isEven);
        if (fastPointer.next == null) return isEven ? slowPointer.next : slowPointer;
        return iterate(isEven ? slowPointer.next : slowPointer, fastPointer.next, !isEven);
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
