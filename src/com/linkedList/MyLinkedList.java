package com.linkedList;

class MyLinkedList {
    private Node head;
    private Node tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node node = getNode(index);
        return node != null ? node.val : -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node prevHead = head;
        head = new Node(val, prevHead, null);
        if (prevHead != null)
            prevHead.prev = head;
        if (tail == null)
            tail = head;
        System.out.println("addAtHead " + val);
        printState();
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node prevTail = tail;
        tail = new Node(val, null, prevTail);
        if (prevTail != null)
            prevTail.next = tail;
        if (head == null)
            head = tail;
        System.out.println("addAtTail " + val);
        printState();
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node prev = getNode(index - 1);
        if (prev != null) {
            Node next = prev.next;
            Node newNode = new Node(val, next, prev);
            if (next != null)
                next.prev = newNode;
            prev.next = newNode;
            if (prev == tail)
                tail = newNode;
        }
        System.out.println("addAtIndex index " + index + " val " + val);
        printState();
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node curr = head;
        int currId = 0;
        while (curr != null) {
            if (currId == index) {
                if (index == 0)
                    head = curr.next;
                if (curr == tail)
                    tail = curr.prev;
                deleteNode(curr);
                return;
            }
            curr = curr.next;
            currId++;
        }
    }

    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;
        System.out.println("deleteAtIndex");
        printState();
    }

    private Node getNode(int index) {
        Node curr = head;
        int currId = 0;
        while (curr != null) {
            if (currId == index)
                return curr;
            curr = curr.next;
            currId++;
        }
        return null;
    }

    private void printState() {
        System.out.println("Head (id 0): " + head);
        if (head != null) {
            Node curr = head.next;
            int currId = 1;
            while (curr != null) {
                System.out.print("id: " + currId + " Element val: " + curr + " ");
                curr = curr.next;
                currId++;
            }
            System.out.println();
        }
        System.out.println("Tail: " + tail);
    }

    private class Node {
        final int val;
        Node next;
        Node prev;

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public String toString() {
            return val + "";
        }
    }
}