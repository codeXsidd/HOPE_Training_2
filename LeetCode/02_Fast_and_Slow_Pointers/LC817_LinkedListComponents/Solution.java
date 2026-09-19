// LeetCode Problem 817: Linked List Components
// Difficulty: Medium
// Link: https://leetcode.com/problems/linked-list-components/

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
    public int numComponents(ListNode head, int[] nums) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int num : nums) set.add(num);

        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr.val) && (curr.next == null || !set.contains(curr.next.val))) {
                count++;
            }
            curr = curr.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{0, 1, 2, 3});
        int[] nums = {0, 1, 3};
        Solution sol = new Solution();
        System.out.println("Connected components: " + sol.numComponents(head, nums));
    }
}
