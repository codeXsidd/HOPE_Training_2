package Tree;

import java.util.*;

public class bst_all_operation {
    class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;

        BSTNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // insert value
    BSTNode root;

    BSTNode insert(BSTNode root, int data) {
        if (root == null) {
            return root = new BSTNode(data);
        } else if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // search the value

    void search(BSTNode root, int data) {
        if (root == null) {
            System.out.println("Element not found");
            return;
        }
        if (root.data == data) {
            System.out.println("Element found");
            return;
        }
        if (data < root.data) {
            search(root.left, data);
        } else {
            search(root.right, data);
        }
    }

    // inorder traversal
    void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // preorder traversal
    void preorder(BSTNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);

        }
    }

    // postorder traversal
    void postorder(BSTNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");

        }
    }

    // count the leaf nodes

    int count = 0;

    void leafCount(BSTNode root) {
        if (root != null) {
            leafCount(root.left);
            if (root.left == null && root.right == null) {
                count++;
            }
            leafCount(root.right);
        }
    }

    // count the nodes
    int totalcount = 0;

    void count(BSTNode root) {
        if (root != null) {
            count(root.left);
            count(root.right);
            totalcount++;
        }
    }

    // level order traversal (BFS)
    void levelOrder(BSTNode root) {
        if (root == null) {
            return;
        }
        Queue<BSTNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BSTNode temp = q.remove();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }

    // min value of BST
        int min(BSTNode root) {
            int min_val = root.data;
            while (root.left != null) {
                min_val = root.data;
                root = root.left;
            }
            return min_val;
        }
    /*
     * max value of BST
     * int max(BSTNode root){
     * int max_val=root.data;
     * while(root.right!=null){
     * max_val=root.data;
     * root=root.right;
     * }
     * return max_val;
     * }
     */

    BSTNode delete(BSTNode root, int target) {
        if (root == null) {
            return root;
        }
        if (target < root.data) {
            root.left = delete(root.left, target);
        } else if (target > root.data) {
            root.right = delete(root.right, target);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = min(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }
    
   // balance tree using heigth
     int height(BSTNode root){
        if(root == null) return -1;
        
        int l_height=height(root.left);
        int r_height=height(root.right);
        
        return Math.max(l_height, r_height) +1;
    }
    
    boolean b_f(BSTNode root){
        if(root == null) return true;
        
        int left_h= height(root.left);
        int right_h=height(root.right);
        
        return Math.abs(left_h-right_h)<=1;
    }

    public static void main(String[] args) {
        bst_all_operation tree = new bst_all_operation();
        tree.root = tree.insert(tree.root, 15);
        tree.insert(tree.root, 12);
        tree.insert(tree.root, 25);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 14);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 35);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 11);

        tree.inorder(tree.root);
        System.out.println();

        /*
         * tree.preorder(tree.root);
         * System.out.println();
         * 
         * tree.postorder(tree.root);
         * System.out.println();
         * 
         * tree.leafCount(tree.root);
         * System.out.println(tree.count);
         * 
         * tree.count(tree.root);
         * System.out.println(tree.totalcount);
         */
        tree.delete(tree.root, 10);
        tree.inorder(tree.root);
        System.out.println();

        if(tree.b_f(tree.root)){
            System.out.println("Balanced tree");
        }
        else{
            System.out.println("Not a Balanced tree");
        }
             
    }

}
