// LeetCode Problem 117: Populating Next Right Pointers in Each Node II
// Difficulty: Medium
// Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

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
        Node curr = root;
        while (curr != null) {
            Node dummy = new Node(0);
            Node tail = dummy;
            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        Solution sol = new Solution();
        sol.connect(root);
        System.out.println("Node 5 next points to 7: " + (root.left.right.next.val == 7));
    }
}
