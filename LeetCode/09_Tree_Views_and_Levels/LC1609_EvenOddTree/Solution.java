// LeetCode Problem 1609: Even Odd Tree
// Difficulty: Medium
// Link: https://leetcode.com/problems/even-odd-tree/

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
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (level % 2 == 0) {
                    if (curr.val % 2 == 0 || curr.val <= prev) return false;
                } else {
                    if (curr.val % 2 != 0 || curr.val >= prev) return false;
                }
                prev = curr.val;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            level++;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(10, new TreeNode(3), null), new TreeNode(4, new TreeNode(7), new TreeNode(9)));
        Solution sol = new Solution();
        System.out.println("Is even-odd tree: " + sol.isEvenOddTree(root));
    }
}
