// LeetCode Problem 236: Lowest Common Ancestor of a Binary Tree
// Difficulty: Medium
// Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

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
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode root = new TreeNode(3, n5, n1);
        Solution sol = new Solution();
        TreeNode lca = sol.lowestCommonAncestor(root, n5, n1);
        System.out.println("LCA val: " + lca.val); // 3
    }
}
