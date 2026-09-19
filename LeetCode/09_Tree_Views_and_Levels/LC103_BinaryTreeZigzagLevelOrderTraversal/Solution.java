// LeetCode Problem 103: Binary Tree Zigzag Level Order Traversal
// Difficulty: Medium
// Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
    public java.util.List<java.util.List<Integer>> zigzagLevelOrder(TreeNode root) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (root == null) return result;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            java.util.LinkedList<Integer> currentLevel = new java.util.LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                if (leftToRight) {
                    currentLevel.addLast(curr.val);
                } else {
                    currentLevel.addFirst(curr.val);
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Solution sol = new Solution();
        System.out.println("Zigzag levels: " + sol.zigzagLevelOrder(root));
    }
}
