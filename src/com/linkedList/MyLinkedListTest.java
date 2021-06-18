package com.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    @Test
    public void firstTest() {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        assertEquals(4, list.get(4));
        list.addAtHead(4);
        list.addAtIndex(5, 0);
        list.addAtHead(6);
    }

    @Test
    public void secondTest() {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        assertEquals(list.get(1), 2);
        list.deleteAtIndex(0);
        assertEquals(list.get(0), 2);
    }

    @Test
    public void thirdTest() {
        MyLinkedList list = new MyLinkedList();
        list.addAtTail(1);
        assertEquals(list.get(0), 1);
    }
}