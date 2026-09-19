// LeetCode Problem 160: Intersection of Two Linked Lists
// Difficulty: Easy
// Link: https://leetcode.com/problems/intersection-of-two-linked-lists/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createList(int[] values) {
        if (values == null || values.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : values) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        ListNode a = new ListNode(4);
        a.next = new ListNode(1);
        a.next.next = common;

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(1);
        b.next.next.next = common;

        Solution sol = new Solution();
        ListNode inter = sol.getIntersectionNode(a, b);
        System.out.println("Intersection node value: " + (inter != null ? inter.val : "null"));
    }
}
