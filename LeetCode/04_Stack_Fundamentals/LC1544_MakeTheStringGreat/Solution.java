// LeetCode Problem 1544: Make The String Great
// Difficulty: Easy
// Link: https://leetcode.com/problems/make-the-string-great/


public class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && Math.abs(sb.charAt(len - 1) - c) == 32) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result for 'leEeetcode': " + sol.makeGood("leEeetcode")); // "leetcode"
    }
}
