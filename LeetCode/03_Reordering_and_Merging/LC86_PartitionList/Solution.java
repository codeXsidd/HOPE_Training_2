// LeetCode Problem 86: Partition List
// Difficulty: Medium
// Link: https://leetcode.com/problems/partition-list/

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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode less = lessHead, greater = greaterHead;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                less.next = curr;
                less = less.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }
        greater.next = null;
        less.next = greaterHead.next;
        return lessHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1, 4, 3, 2, 5, 2});
        Solution sol = new Solution();
        ListNode partitioned = sol.partition(head, 3);
        System.out.print("Partitioned list (x=3): ");
        ListNode.printList(partitioned);
    }
}
