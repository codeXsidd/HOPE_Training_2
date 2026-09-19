// LeetCode Problem 116: Populating Next Right Pointers in Each Node
// Difficulty: Medium
// Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    public Node(int _val) { val = _val; }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Solution sol = new Solution();
        sol.connect(root);
        System.out.println("Node 4 next is node 5: " + (root.left.left.next.val == 5));
        System.out.println("Node 5 next is node 6: " + (root.left.right.next.val == 6));
    }
}
