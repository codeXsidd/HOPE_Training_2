package Tree;

import java.util.*;

public class contruct_tree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = right = null;
        }
    }

    Node root;

    // Inorder Traversal
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Level Order View
    static Node lvo() {
        Scanner s = new Scanner(System.in);
        int val = s.nextInt();
        if (val == -1) {
            return null;
        }

        Node temp = new Node(val);
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            int l = s.nextInt();
            if (l != -1) {
                curr.left = new Node(l);
                q.add(curr.left);
            }

            int r = s.nextInt();
            if (r != -1) {
                curr.right = new Node(r);
                q.add(curr.right);
            }
        }
        return temp;
    }

    // Print Nodes using Queue
    void printLevelOrder(Node root) {
        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        contruct_tree d = new contruct_tree();
        /*
         * d.root = new Node(1);
         * d.root.left = new Node(2);
         * d.root.right = new Node(3);
         * d.root.left.left = new Node(4);
         * d.root.left.right = new Node(5);
         * d.inorder(d.root);
         */

        d.root = lvo();
        d.inorder(d.root);
    }
}