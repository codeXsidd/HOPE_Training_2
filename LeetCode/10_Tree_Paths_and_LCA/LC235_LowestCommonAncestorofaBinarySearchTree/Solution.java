// LeetCode Problem 235: Lowest Common Ancestor of a Binary Search Tree
// Difficulty: Medium
// Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(2);
        TreeNode n8 = new TreeNode(8);
        TreeNode root = new TreeNode(6, n2, n8);
        Solution sol = new Solution();
        TreeNode lca = sol.lowestCommonAncestor(root, n2, n8);
        System.out.println("BST LCA val: " + lca.val); // 6
    }
}
