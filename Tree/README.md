# Tree Data Structure Operations (Java)

This directory contains clean, modular Java implementations of Binary Search Tree (BST) operations and tree algorithms.

---

## 📑 Contents

1. [BST All Operations (`bst_all_operation.java`)](#1-bst-all-operations)
2. [Count Leaf Nodes (`count_leaf_nodes.java`)](#2-count-leaf-nodes)
3. [Count Total Nodes (`count_nodes.java`)](#3-count-total-nodes)
4. [Level Order Traversal / BFS (`level_order.java`)](#4-level-order-traversal-bfs)
5. [Balance Tree & Height Check (`balance_tree.java`)](#5-balance-tree--height-check)

---

## 1. BST All Operations
**File:** [`bst_all_operation.java`](bst_all_operation.java)

A comprehensive Binary Search Tree covering essential BST mechanics:
- **Insertion**: Recursively places keys based on BST property (`left < root < right`).
- **Searching**: Standard logarithmic search (`O(h)`).
- **Depth-First Traversals**:
  - `inorder` (Left, Root, Right) -> yields sorted order.
  - `preorder` (Root, Left, Right)
  - `postorder` (Left, Right, Root)
- **Min / Max**: Traverses to the leftmost or rightmost node.
- **Deletion**: Handles all 3 deletion cases:
  1. Node with no child (leaf).
  2. Node with 1 child.
  3. Node with 2 children (replaces with inorder successor/minimum of right subtree).

---

## 2. Count Leaf Nodes
**File:** [`count_leaf_nodes.java`](count_leaf_nodes.java)

A leaf node is any node that does **not** have any children (`left == null && right == null`).

### Methods Implemented:
- **Approach 1 (Inorder Traversal Counter)**:
  Increments a counter whenever a node with `root.left == null && root.right == null` is encountered.
- **Approach 2 (Pure Recursive Function)**:
  ```java
  int countLeaves(Node root) {
      if (root == null) return 0;
      if (root.left == null && root.right == null) return 1;
      return countLeaves(root.left) + countLeaves(root.right);
  }
  ```

---

## 3. Count Total Nodes
**File:** [`count_nodes.java`](count_nodes.java)

Counts the total number of nodes present in the binary tree.

### Methods Implemented:
- **Approach 1 (Instance Counter)**: Visits each node and increments `totalcount++`.
- **Approach 2 (Pure Recursive Function)**:
  ```java
  int countTotalNodes(Node root) {
      if (root == null) return 0;
      return 1 + countTotalNodes(root.left) + countTotalNodes(root.right);
  }
  ```

---

## 4. Level Order Traversal (BFS)
**File:** [`level_order.java`](level_order.java)

Breadth-First Search (BFS) visits nodes level-by-level from left to right using a `Queue` (`LinkedList`).

### How It Works:
1. Enqueue the root.
2. While the queue is not empty:
   - Dequeue the front node and print its value.
   - Enqueue its `left` child (if non-null).
   - Enqueue its `right` child (if non-null).
3. Also provides a `levelOrderByLevel` method to print each tree level on its own line.

---

## 5. Balance Tree & Height Check
**File:** [`balance_tree.java`](balance_tree.java)

Measures tree height and determines whether a binary tree is height-balanced (similar to AVL tree criteria).

### Key Concepts:
- **Height Calculation**:
  ```java
  int height(Node root) {
      if (root == null) return -1;
      return Math.max(height(root.left), height(root.right)) + 1;
  }
  ```
- **Balance Factor (`b_f`)**:
  Difference between left and right subtree heights: $|left\_h - right\_h| \le 1$.
- **Full Tree Balance (`isBalanced`)**:
  Ensures that the root is balanced **and** every subtree is also balanced recursively.

---

## 💻 Running the Programs

From the root project directory:

```bash
# Compile all files
javac Tree/*.java

# Run individual programs
java Tree.bst_all_operation
java Tree.count_leaf_nodes
java Tree.count_nodes
java Tree.level_order
java Tree.balance_tree
```
