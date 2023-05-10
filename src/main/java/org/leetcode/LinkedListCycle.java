package org.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        ListNode next3 = new ListNode(-4, null);
        ListNode next2 = new ListNode(0, next3);
        ListNode next1 = new ListNode(2, next2);
        ListNode head = new ListNode(3, next1);

        System.out.println(linkedListCycle.hasCycle(head));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}