// LeetCode Problem 239: Sliding Window Maximum
// Difficulty: Hard
// Link: https://leetcode.com/problems/sliding-window-maximum/


public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indices out of current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // Remove smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] maxs = sol.maxSlidingWindow(nums, 3);
        System.out.println("Sliding window max: " + java.util.Arrays.toString(maxs));
    }
}
