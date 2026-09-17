package Tree;

public class count_nodes {
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

    // Approach 1: Using instance variable
    int totalcount = 0;

    void count(Node root) {
        if (root != null) {
            count(root.left);
            count(root.right);
            totalcount++;
        }
    }

    // Approach 2: Recursive method returning total count directly
    int countTotalNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countTotalNodes(root.left) + countTotalNodes(root.right);
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
        count_nodes tree = new count_nodes();
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

        // Using instance counter
        tree.count(tree.root);
        System.out.println("Total nodes (Approach 1): " + tree.totalcount);

        // Using recursive return method
        System.out.println("Total nodes (Approach 2): " + tree.countTotalNodes(tree.root));
    }
}
