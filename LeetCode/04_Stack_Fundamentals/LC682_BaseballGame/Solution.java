// LeetCode Problem 682: Baseball Game
// Difficulty: Easy
// Link: https://leetcode.com/problems/baseball-game/


public class Solution {
    public int calPoints(String[] operations) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int total = 0;
        for (int score : stack) total += score;
        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println("Total score: " + sol.calPoints(ops));
    }
}
