package Tree;

public class AVL {
    public static class Node {
        public int data;
        public int height;
        public Node left, right;

        public Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    public Node root;

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int balance_f(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Left rotate subtree rooted with x
    public Node leftrotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = t2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Right rotate subtree rooted with y
    public Node rightrotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = t2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Public convenience insert method (updates root)
    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    // Standard recursive AVL insert returning the new subtree root
    public Node insert(Node node, int data) {
        // 1. Normal BST insertion
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            // Duplicate keys are not inserted in standard AVL
            return node;
        }

        // 2. Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Get balance factor to check whether this node became unbalanced
        int balance = balance_f(node);

        // Case 1: Left Left (LL)
        if (balance > 1 && data < node.left.data) {
            return rightrotate(node);
        }

        // Case 2: Right Right (RR)
        if (balance < -1 && data > node.right.data) {
            return leftrotate(node);
        }

        // Case 3: Left Right (LR)
        if (balance > 1 && data > node.left.data) {
            node.left = leftrotate(node.left);
            return rightrotate(node);
        }

        // Case 4: Right Left (RL)
        if (balance < -1 && data < node.right.data) {
            node.right = rightrotate(node.right);
            return leftrotate(node);
        }

        return node;
    }

    // Helper to find the node with minimum value
    public Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Public convenience delete method
    public void delete(int data) {
        this.root = delete(this.root, data);
    }

    // Delete a node and rebalance
    public Node delete(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            // Node to be deleted found
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                Node temp = minValueNode(node.right);
                node.data = temp.data;
                node.right = delete(node.right, temp.data);
            }
        }

        if (node == null) {
            return null;
        }

        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Balance factor
        int balance = balance_f(node);

        // Rebalance
        // LL Case
        if (balance > 1 && balance_f(node.left) >= 0) {
            return rightrotate(node);
        }
        // LR Case
        if (balance > 1 && balance_f(node.left) < 0) {
            node.left = leftrotate(node.left);
            return rightrotate(node);
        }
        // RR Case
        if (balance < -1 && balance_f(node.right) <= 0) {
            return leftrotate(node);
        }
        // RL Case
        if (balance < -1 && balance_f(node.right) > 0) {
            node.right = rightrotate(node.right);
            return leftrotate(node);
        }

        return node;
    }

    // Checks if any subtree is unbalanced (|balance| > 1)
    public boolean isUnbalanced(Node root) {
        if (root == null) {
            return false;
        }
        int balance = balance_f(root);
        if (balance > 1 || balance < -1) {
            return true;
        }
        return isUnbalanced(root.left) || isUnbalanced(root.right);
    }

    // Checks if the entire tree is balanced
    public boolean isBalanced(Node root) {
        return !isUnbalanced(root);
    }

    // Backward-compatible method signature
    public boolean bf(Node root, int data) {
        return isUnbalanced(root);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        int[] values = {10, 20, 30, 40, 50, 25, 67, 784};

        for (int val : values) {
            tree.insert(val);
        }

        System.out.println("Inorder traversal of constructed AVL tree (sorted):");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.println("Preorder traversal (root first):");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println("Root of AVL tree: " + (tree.root != null ? tree.root.data : "null"));
        System.out.println("Tree height: " + tree.height(tree.root));

        if (tree.isBalanced(tree.root)) {
            System.out.println("The tree is balanced");
        } else {
            System.out.println("The tree is not balanced");
        }

        // Demonstrate deletion
        System.out.println("\nDeleting 40 from AVL tree...");
        tree.delete(40);
        System.out.print("Inorder after deletion: ");
        tree.inOrder(tree.root);
        System.out.println();

        if (tree.isBalanced(tree.root)) {
            System.out.println("The tree remains balanced after deletion");
        } else {
            System.out.println("The tree is not balanced");
        }
    }
}
