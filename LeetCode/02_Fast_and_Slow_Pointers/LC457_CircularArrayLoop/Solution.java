// LeetCode Problem 457: Circular Array Loop
// Difficulty: Medium
// Link: https://leetcode.com/problems/circular-array-loop/


public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            int slow = i, fast = getNextIndex(nums, i);
            boolean forward = nums[i] > 0;
            while (nums[fast] * nums[i] > 0 && nums[getNextIndex(nums, fast)] * nums[i] > 0) {
                if (slow == fast) {
                    if (slow == getNextIndex(nums, slow)) break; // cycle length 1
                    return true;
                }
                slow = getNextIndex(nums, slow);
                fast = getNextIndex(nums, getNextIndex(nums, fast));
            }
            // mark visited
            slow = i;
            int val = nums[i];
            while (nums[slow] * val > 0) {
                int next = getNextIndex(nums, slow);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }

    private int getNextIndex(int[] nums, int i) {
        int n = nums.length;
        int next = (i + nums[i]) % n;
        return next >= 0 ? next : next + n;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {2, -1, 1, 2, 2};
        System.out.println("Loop in [2, -1, 1, 2, 2]: " + sol.circularArrayLoop(nums1));
    }
}
