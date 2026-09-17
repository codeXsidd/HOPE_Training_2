package Tree;

public class balance_tree {
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

    // Calculate height of tree using height of subtrees
    // Height of empty tree is -1 (or 0 depending on convention; -1 means single node has height 0)
    int height(Node root) {
        if (root == null) {
            return -1;
        }
        int l_height = height(root.left);
        int r_height = height(root.right);

        return Math.max(l_height, r_height) + 1;
    }

    // Balance factor check at current node: |left_h - right_h| <= 1
    boolean b_f(Node root) {
        if (root == null) {
            return true;
        }

        int left_h = height(root.left);
        int right_h = height(root.right);

        return Math.abs(left_h - right_h) <= 1;
    }

    // Check if the entire tree is balanced (checks every subtree recursively)
    boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int left_h = height(root.left);
        int right_h = height(root.right);

        // A tree is balanced if:
        // 1. Difference of heights of left and right subtrees is at most 1
        // 2. Left subtree is balanced
        // 3. Right subtree is balanced
        return Math.abs(left_h - right_h) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // Inorder traversal
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        balance_tree tree = new balance_tree();
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

        System.out.println("Tree height: " + tree.height(tree.root));

        // Balance check at root
        if (tree.b_f(tree.root)) {
            System.out.println("Root has balanced factor (|left_h - right_h| <= 1)");
        } else {
            System.out.println("Root is not balanced");
        }

        // Full tree balance check
        if (tree.isBalanced(tree.root)) {
            System.out.println("Entire tree is a Balanced tree");
        } else {
            System.out.println("Entire tree is NOT a Balanced tree");
        }
    }
}
