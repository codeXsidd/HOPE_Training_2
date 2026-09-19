// LeetCode Problem 844: Backspace String Compare
// Difficulty: Easy
// Link: https://leetcode.com/problems/backspace-string-compare/


public class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Compare 'ab#c' and 'ad#c': " + sol.backspaceCompare("ab#c", "ad#c"));
    }
}
