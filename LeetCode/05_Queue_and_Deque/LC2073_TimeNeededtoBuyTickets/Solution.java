// LeetCode Problem 2073: Time Needed to Buy Tickets
// Difficulty: Easy
// Link: https://leetcode.com/problems/time-needed-to-buy-tickets/


public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], tickets[k]);
            } else {
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] tickets = {2, 3, 2};
        System.out.println("Time taken: " + sol.timeRequiredToBuy(tickets, 2));
    }
}
