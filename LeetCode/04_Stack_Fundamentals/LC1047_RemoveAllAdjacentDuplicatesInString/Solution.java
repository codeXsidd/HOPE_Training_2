// LeetCode Problem 1047: Remove All Adjacent Duplicates In String
// Difficulty: Easy
// Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/


public class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == c) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result: " + sol.removeDuplicates("abbaca")); // "ca"
    }
}
