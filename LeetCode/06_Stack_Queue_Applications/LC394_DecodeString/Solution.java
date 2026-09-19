// LeetCode Problem 394: Decode String
// Difficulty: Medium
// Link: https://leetcode.com/problems/decode-string/


public class Solution {
    public String decodeString(String s) {
        java.util.Stack<Integer> countStack = new java.util.Stack<>();
        java.util.Stack<StringBuilder> stringStack = new java.util.Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decoded = stringStack.pop();
                int repeat = countStack.pop();
                for (int i = 0; i < repeat; i++) {
                    decoded.append(currentString);
                }
                currentString = decoded;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Decoded '3[a]2[bc]': " + sol.decodeString("3[a]2[bc]"));
    }
}
