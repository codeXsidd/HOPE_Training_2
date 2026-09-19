// LeetCode Problem 234: Palindrome Linked List
// Difficulty: Easy
// Link: https://leetcode.com/problems/palindrome-linked-list/

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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        // Compare halves
        ListNode first = head, second = prev;
        while (second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.createList(new int[]{1, 2, 2, 1});
        ListNode head2 = ListNode.createList(new int[]{1, 2});
        
        Solution sol = new Solution();
        System.out.println("[1, 2, 2, 1] is palindrome: " + sol.isPalindrome(head1));
        System.out.println("[1, 2] is palindrome: " + sol.isPalindrome(head2));
    }
}
