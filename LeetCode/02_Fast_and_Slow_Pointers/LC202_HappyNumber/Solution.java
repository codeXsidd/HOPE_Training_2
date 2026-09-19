// LeetCode Problem 202: Happy Number
// Difficulty: Easy
// Link: https://leetcode.com/problems/happy-number/


public class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Is 19 happy? " + sol.isHappy(19));
        System.out.println("Is 2 happy? " + sol.isHappy(2));
    }
}
