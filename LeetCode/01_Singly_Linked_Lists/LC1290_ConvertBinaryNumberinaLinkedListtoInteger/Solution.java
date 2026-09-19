// LeetCode Problem 1290: Convert Binary Number in a Linked List to Integer
// Difficulty: Easy
// Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

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
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        ListNode curr = head;
        while (curr != null) {
            ans = (ans << 1) | curr.val;
            curr = curr.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1, 0, 1});
        System.out.print("Binary list: ");
        ListNode.printList(head);
        
        Solution sol = new Solution();
        System.out.println("Decimal value: " + sol.getDecimalValue(head));
    }
}
