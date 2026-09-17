package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class level_order {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node root;

    // Insert value into BST
    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // Level order traversal (BFS) using Queue
    void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.remove();
            System.out.print(temp.data + " ");

            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }

    // Optional: Level order printing line-by-line per level
    void levelOrderByLevel(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node temp = q.remove();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        level_order tree = new level_order();
        tree.root = tree.insert(tree.root, 15);
        tree.insert(tree.root, 12);
        tree.insert(tree.root, 25);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 14);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 35);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 11);

        System.out.print("Level Order Traversal (BFS): ");
        tree.levelOrder(tree.root);
        System.out.println("\n");

        System.out.println("Level Order Traversal (Line by line):");
        tree.levelOrderByLevel(tree.root);
    }
}
