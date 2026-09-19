// LeetCode Problem 138: Copy List with Random Pointer
// Difficulty: Medium
// Link: https://leetcode.com/problems/copy-list-with-random-pointer/

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Interleave cloned nodes
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Step 2: Assign random pointers for cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate original and cloned lists
        curr = head;
        Node cloneHead = head.next;
        Node cloneCurr = cloneHead;
        while (curr != null) {
            curr.next = curr.next.next;
            if (cloneCurr.next != null) {
                cloneCurr.next = cloneCurr.next.next;
            }
            curr = curr.next;
            cloneCurr = cloneCurr.next;
        }
        return cloneHead;
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        n1.next = n2;
        n2.next = n3;
        n2.random = n1;
        n3.random = n2;

        Solution sol = new Solution();
        Node copy = sol.copyRandomList(n1);
        System.out.println("Successfully deep copied list! Cloned root val: " + copy.val);
        System.out.println("Cloned node 2 random val: " + copy.next.random.val);
    }
}
