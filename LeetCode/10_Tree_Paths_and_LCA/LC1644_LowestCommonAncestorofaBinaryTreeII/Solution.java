// LeetCode Problem 1644: Lowest Common Ancestor of a Binary Tree II
// Difficulty: Medium
// Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/

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
        boolean[] found = new boolean[2]; // found[0]=p, found[1]=q
        TreeNode lca = findLCA(root, p, q, found);
        return (found[0] && found[1]) ? lca : null;
    }

    private TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q, boolean[] found) {
        if (node == null) return null;
        TreeNode left = findLCA(node.left, p, q, found);
        TreeNode right = findLCA(node.right, p, q, found);

        if (node == p) {
            found[0] = true;
            return node;
        }
        if (node == q) {
            found[1] = true;
            return node;
        }
        if (left != null && right != null) return node;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode root = new TreeNode(3, p, q);
        Solution sol = new Solution();
        TreeNode ans = sol.lowestCommonAncestor(root, p, q);
        System.out.println("LCA II val: " + (ans != null ? ans.val : "null"));
    }
}
