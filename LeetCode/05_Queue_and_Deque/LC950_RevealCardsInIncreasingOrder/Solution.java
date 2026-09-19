// LeetCode Problem 950: Reveal Cards In Increasing Order
// Difficulty: Medium
// Link: https://leetcode.com/problems/reveal-cards-in-increasing-order/


public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        java.util.Arrays.sort(deck);
        java.util.Queue<Integer> indexQueue = new java.util.LinkedList<>();
        for (int i = 0; i < n; i++) indexQueue.add(i);

        int[] result = new int[n];
        for (int card : deck) {
            result[indexQueue.poll()] = card;
            if (!indexQueue.isEmpty()) {
                indexQueue.add(indexQueue.poll());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] res = sol.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});
        System.out.println("Revealed order: " + java.util.Arrays.toString(res));
    }
}
