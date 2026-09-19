// LeetCode Problem 739: Daily Temperatures
// Difficulty: Medium
// Link: https://leetcode.com/problems/daily-temperatures/


public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                answer[prevDay] = i - prevDay;
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = sol.dailyTemperatures(temps);
        System.out.println("Days to wait: " + java.util.Arrays.toString(res));
    }
}
