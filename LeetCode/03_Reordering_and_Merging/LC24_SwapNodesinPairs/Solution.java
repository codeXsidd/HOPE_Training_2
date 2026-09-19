// LeetCode Problem 24: Swap Nodes in Pairs
// Difficulty: Medium
// Link: https://leetcode.com/problems/swap-nodes-in-pairs/

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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            first.next = second.next;
            second.next = first;
            curr.next = second;
            curr = first;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1, 2, 3, 4});
        Solution sol = new Solution();
        ListNode swapped = sol.swapPairs(head);
        System.out.print("Swapped pairs: ");
        ListNode.printList(swapped);
    }
}
