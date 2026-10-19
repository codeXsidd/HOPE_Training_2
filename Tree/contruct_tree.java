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

    // Level Order View with custom Scanner
    static Node lvo(Scanner s) {
        if (!s.hasNextInt()) {
            return null;
        }
        int val = s.nextInt();
        if (val == -1) {
            return null;
        }

        Node temp = new Node(val);
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (!s.hasNextInt()) break;
            int l = s.nextInt();
            if (l != -1) {
                curr.left = new Node(l);
                q.add(curr.left);
            }

            if (!s.hasNextInt()) break;
            int r = s.nextInt();
            if (r != -1) {
                curr.right = new Node(r);
                q.add(curr.right);
            }
        }
        return temp;
    }

    // Default Level Order View reading from System.in
    static Node lvo() {
        return lvo(new Scanner(System.in));
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
        System.out.println("--- Construct Binary Tree from Level Order ---");

        Scanner s;
        try {
            if (System.in.available() > 0) {
                s = new Scanner(System.in);
            } else {
                System.out.println("No interactive input detected; using sample input: 1 2 3 4 5 -1 -1 -1 -1 -1 -1");
                s = new Scanner("1 2 3 4 5 -1 -1 -1 -1 -1 -1");
            }
        } catch (Exception e) {
            s = new Scanner("1 2 3 4 5 -1 -1 -1 -1 -1 -1");
        }

        d.root = lvo(s);
        System.out.print("Inorder Traversal: ");
        d.inorder(d.root);
        System.out.println();
        System.out.print("Level Order Traversal: ");
        d.printLevelOrder(d.root);
    }
}