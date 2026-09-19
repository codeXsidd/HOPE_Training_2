# [LeetCode 933] Number of Recent Calls

- **Topic:** Queue & Deque
- **Difficulty:** Easy
- **LeetCode Link:** [Number of Recent Calls](https://leetcode.com/problems/number-of-recent-calls/)

---

## 📌 Problem Statement

You have a RecentCounter class which counts the number of recent requests within a certain time frame [t - 3000, t].

---

## 💡 Key Algorithmic Idea

- **Core Technique:** Utilizes standard queue & deque patterns.
- **Approach:**
  - Understand the problem constraints and boundary conditions.
  - Implement optimal solution avoiding redundant state or allocations.
  - Maintain clean pointer/state manipulation.

---

## ⏱️ Complexity Analysis

- **Time Complexity:** `O(1) amortized per ping`
- **Space Complexity:** `O(W) where W is max requests within 3000 ms window`

---

## 🚀 How to Run

Compile and execute the standalone test runner:

```bash
javac Solution.java
java Solution
```
