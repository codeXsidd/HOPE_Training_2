// LeetCode Problem 662: Maximum Width of Binary Tree
// Difficulty: Medium
// Link: https://leetcode.com/problems/maximum-width-of-binary-tree/

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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 0;
        java.util.Queue<Pair> queue = new java.util.LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            long minIdx = queue.peek().idx; // offset to prevent overflow
            long first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                long curIdx = p.idx - minIdx;
                if (i == 0) first = curIdx;
                if (i == size - 1) last = curIdx;
                if (p.node.left != null) queue.offer(new Pair(p.node.left, 2 * curIdx));
                if (p.node.right != null) queue.offer(new Pair(p.node.right, 2 * curIdx + 1));
            }
            maxWidth = (int) Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }

    private static class Pair {
        TreeNode node;
        long idx;
        Pair(TreeNode n, long i) { node = n; idx = i; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        Solution sol = new Solution();
        System.out.println("Maximum width: " + sol.widthOfBinaryTree(root));
    }
}
