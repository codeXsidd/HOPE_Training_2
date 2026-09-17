# Data Structures & Algorithms in Java

A clean, modular repository implementing fundamental Data Structures and Algorithms in Java. Every file is self-contained with complete documentation, sample inputs, and an executable `main` method.

---

## 📁 Repository Structure

```
├── Tree/
│   ├── bst_all_operation.java   # Complete Binary Search Tree (BST) operations
│   ├── count_leaf_nodes.java    # Count leaf nodes in BST
│   ├── count_nodes.java         # Count total nodes in BST
│   ├── level_order.java         # Level Order Traversal (BFS) using Queue
│   ├── balance_tree.java        # Height calculation & Balance factor check
│   └── README.md                # Detailed guide on Tree operations
│
├── Stack/
│   ├── array.java               # Fixed-size Stack using Array
│   └── singly.java              # Dynamic Stack using Singly Linked List
│
├── Queue/
│   └── queue.java               # Circular Queue using Array
│
├── LinkedList/
│   ├── singlylist.java          # Singly Linked List (insert, delete, search, display)
│   └── doublylist.java          # Doubly Linked List (bidirectional traversal, insert, delete)
│
├── .gitignore                   # Excludes .class files and IDE configurations
└── README.md                    # Main project documentation
```

---

## 🌳 1. Tree Module (`Tree/`)

| File | Description | Key Methods |
| :--- | :--- | :--- |
| [`bst_all_operation.java`](Tree/bst_all_operation.java) | Comprehensive BST implementation with insert, search, delete, traversals, and balance checks | `insert()`, `search()`, `delete()`, `inorder()`, `preorder()`, `postorder()`, `min()`, `height()`, `b_f()` |
| [`count_leaf_nodes.java`](Tree/count_leaf_nodes.java) | Counts leaf nodes (`left == null && right == null`) via traversal & recursion | `leafCount()`, `countLeaves()` |
| [`count_nodes.java`](Tree/count_nodes.java) | Counts total nodes in a binary tree | `count()`, `countTotalNodes()` |
| [`level_order.java`](Tree/level_order.java) | Breadth-First Search (BFS) level-order traversal using a Queue | `levelOrder()`, `levelOrderByLevel()` |
| [`balance_tree.java`](Tree/balance_tree.java) | Computes subtree height and validates balance factor (`|left_h - right_h| <= 1`) | `height()`, `b_f()`, `isBalanced()` |

> For code deep-dives, see the [Tree Documentation](Tree/README.md).

---

## 🥞 2. Stack Module (`Stack/`)

| File | Implementation | Key Operations |
| :--- | :--- | :--- |
| [`array.java`](Stack/array.java) | Array-backed fixed stack | `push()`, `pop()`, `peek()`, `isEmpty()`, `isFull()`, `size()`, `display()` |
| [`singly.java`](Stack/singly.java) | Linked-list-backed dynamic stack | `push()`, `pop()`, `peek()`, `isEmpty()`, `size()`, `display()` |

---

## 🚶 3. Queue Module (`Queue/`)

| File | Implementation | Key Operations |
| :--- | :--- | :--- |
| [`queue.java`](Queue/queue.java) | Efficient circular queue using an array | `enqueue()`, `dequeue()`, `peek()`, `isEmpty()`, `isFull()`, `size()`, `display()` |

---

## 🔗 4. Linked List Module (`LinkedList/`)

| File | Implementation | Key Operations |
| :--- | :--- | :--- |
| [`singlylist.java`](LinkedList/singlylist.java) | Singly linked list | `insertAtBeginning()`, `insertAtEnd()`, `delete()`, `search()`, `display()` |
| [`doublylist.java`](LinkedList/doublylist.java) | Doubly linked list | `insertAtBeginning()`, `insertAtEnd()`, `delete()`, `displayForward()`, `displayBackward()` |

---

## 🚀 How to Compile & Run

### 1. Compile All Files at Once
```bash
javac LinkedList/*.java Queue/*.java Stack/*.java Tree/*.java
```

### 2. Run Individual Programs
```bash
# Tree operations
java Tree.bst_all_operation
java Tree.count_leaf_nodes
java Tree.count_nodes
java Tree.level_order
java Tree.balance_tree

# Stack operations
java Stack.array
java Stack.singly

# Queue operations
java Queue.queue

# Linked List operations
java LinkedList.singlylist
java LinkedList.doublylist
```

---

## 🛠️ Pushing to GitHub

To push your code to your GitHub repository:

```bash
# 1. Add your remote repository (replace with your repository link)
git remote add origin https://github.com/<username>/<repository-name>.git

# 2. Push to the main branch
git push -u origin main
```
