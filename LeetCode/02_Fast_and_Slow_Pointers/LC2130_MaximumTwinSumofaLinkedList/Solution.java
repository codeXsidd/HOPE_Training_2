// LeetCode Problem 2130: Maximum Twin Sum of a Linked List
// Difficulty: Medium
// Link: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

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
    public int pairSum(ListNode head) {
        // 1. Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2. Reverse second half
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 3. Compute maximum twin sum
        int maxTwinSum = 0;
        ListNode p1 = head, p2 = prev;
        while (p2 != null) {
            maxTwinSum = Math.max(maxTwinSum, p1.val + p2.val);
            p1 = p1.next;
            p2 = p2.next;
        }
        return maxTwinSum;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{5, 4, 2, 1});
        Solution sol = new Solution();
        System.out.println("Max twin sum: " + sol.pairSum(head));
    }
}
