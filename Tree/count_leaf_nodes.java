package Tree;

public class count_leaf_nodes {
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

    // Approach 1: Using global variable / traversal
    int count = 0;

    void leafCount(Node root) {
        if (root != null) {
            leafCount(root.left);
            // Leaf node has no left child and no right child
            if (root.left == null && root.right == null) {
                count++;
            }
            leafCount(root.right);
        }
    }

    // Approach 2: Functional recursion returning the count directly
    int countLeaves(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // Inorder traversal to display elements
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        count_leaf_nodes tree = new count_leaf_nodes();
        tree.root = tree.insert(tree.root, 15);
        tree.insert(tree.root, 12);
        tree.insert(tree.root, 25);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 14);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 35);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 11);

        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        // Using traversal approach
        tree.leafCount(tree.root);
        System.out.println("Total leaf nodes (Approach 1): " + tree.count);

        // Using functional recursion approach
        int totalLeaves = tree.countLeaves(tree.root);
        System.out.println("Total leaf nodes (Approach 2): " + totalLeaves);
    }
}
