package com.vodopolov.addTwoNumbers;

/**
 * Created by Anton on 28.02.2020.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNumbersHelper(l1, l2, 0);
    }

    private ListNode addNumbersHelper(ListNode l1, ListNode l2, int numToAdd) {
        ListNode result;
        if (l1 == null && l2 == null) result = numToAdd > 0 ? new ListNode(numToAdd) : null;
        else {
            int sum = numToAdd;
            if (l1 != null) {
               sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            result = new ListNode(sum % 10);
            result.next = addNumbersHelper(l1 != null ? l1.next : null, l2 != null ? l2.next : null, sum > 9 ? 1 : 0);
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
