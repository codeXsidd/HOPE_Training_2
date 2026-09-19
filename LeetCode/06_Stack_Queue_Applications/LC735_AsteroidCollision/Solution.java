// LeetCode Problem 735: Asteroid Collision
// Difficulty: Medium
// Link: https://leetcode.com/problems/asteroid-collision/


public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int ast : asteroids) {
            boolean alive = true;
            while (alive && ast < 0 && !stack.isEmpty() && stack.peek() > 0) {
                if (stack.peek() < -ast) {
                    stack.pop();
                } else if (stack.peek() == -ast) {
                    stack.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }
            if (alive) stack.push(ast);
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = stack.pop();
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] res = sol.asteroidCollision(new int[]{5, 10, -5});
        System.out.println("Remaining asteroids: " + java.util.Arrays.toString(res));
    }
}
