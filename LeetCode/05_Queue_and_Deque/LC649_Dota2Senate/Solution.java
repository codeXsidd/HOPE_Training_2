// LeetCode Problem 649: Dota2 Senate
// Difficulty: Medium
// Link: https://leetcode.com/problems/dota2-senate/


public class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        java.util.Queue<Integer> radiant = new java.util.LinkedList<>();
        java.util.Queue<Integer> dire = new java.util.LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') radiant.add(i);
            else dire.add(i);
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIdx = radiant.poll();
            int dIdx = dire.poll();
            if (rIdx < dIdx) {
                radiant.add(rIdx + n);
            } else {
                dire.add(dIdx + n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Winner for 'RD': " + sol.predictPartyVictory("RD"));
        System.out.println("Winner for 'RDD': " + sol.predictPartyVictory("RDD"));
    }
}
