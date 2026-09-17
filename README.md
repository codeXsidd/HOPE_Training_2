# Data Structures & Algorithms in Java

A clean, modular repository implementing fundamental Data Structures and Algorithms in Java. Every file is self-contained with complete documentation, sample inputs, and an executable `main` method.

---

## 📁 Repository & Documentation Map

```
├── Tree/
│   ├── bst_all_operation.java   # Complete Binary Search Tree (BST) operations
│   ├── count_leaf_nodes.java    # Count leaf nodes in BST
│   ├── count_nodes.java         # Count total nodes in BST
│   ├── level_order.java         # Level Order Traversal (BFS) using Queue
│   ├── balance_tree.java        # Height calculation & Balance factor check
│   └── README.md                # 📖 Tree Module Documentation
│
├── Queue/
│   ├── linear_queue.java        # Linear Queue using Array (Fixed Size)
│   ├── circular_queue.java      # Circular Queue using Array (Reuses slots)
│   ├── linked_list_queue.java   # Queue using Singly Linked List (Dynamic)
│   ├── queue.java               # Standard Queue implementation
│   └── README.md                # 📖 Queue Module Documentation
│
├── Stack/
│   ├── array.java               # Fixed-size Stack using Array
│   ├── singly.java              # Dynamic Stack using Singly Linked List
│   └── README.md                # 📖 Stack Module Documentation
│
├── LinkedList/
│   ├── singlylist.java          # Singly Linked List (insert, delete, search, display)
│   ├── doublylist.java          # Doubly Linked List (bidirectional traversal, insert, delete)
│   └── README.md                # 📖 Linked List Module Documentation
│
├── .gitignore                   # Excludes .class files and IDE configurations
├── LICENSE                      # MIT License
└── README.md                    # 📖 Main Project Documentation
```

---

## 📑 Project Documentation Index

| Document | Location | Description |
| :--- | :--- | :--- |
| **Main Guide** | [`README.md`](README.md) | Complete project overview, architecture map, compilation and run instructions, and GitHub push workflow. |
| **Tree Guide** | [`Tree/README.md`](Tree/README.md) | In-depth BST guide: Insertion, Deletion cases, DFS Traversals, BFS Level Order, Height calculation, and AVL balance factor. |
| **Queue Guide** | [`Queue/README.md`](Queue/README.md) | Linear vs Circular vs Linked List Queue comparison, $O(1)$ complexities, and circular memory reuse explanation. |
| **Stack Guide** | [`Stack/README.md`](Stack/README.md) | Array-based vs Linked-List-based Stack comparison, LIFO semantics, boundary checks, and overflow/underflow handling. |
| **Linked List Guide** | [`LinkedList/README.md`](LinkedList/README.md) | Singly vs Doubly Linked List, bidirectional traversal, pointer maintenance, and algorithmic operations. |
| **Git Ignore** | [`.gitignore`](.gitignore) | Excludes compiled `.class` binaries, `.vscode/`, `.idea/`, and temporary build artifacts. |
| **License** | [`LICENSE`](LICENSE) | MIT open source software license. |

---

## 🌳 1. Tree Module (`Tree/`)

| File | Description | Key Methods |
| :--- | :--- | :--- |
| [`bst_all_operation.java`](Tree/bst_all_operation.java) | Comprehensive BST implementation with insert, search, delete, traversals, and balance checks | `insert()`, `search()`, `delete()`, `inorder()`, `preorder()`, `postorder()`, `min()`, `height()`, `b_f()` |
| [`count_leaf_nodes.java`](Tree/count_leaf_nodes.java) | Counts leaf nodes (`left == null && right == null`) via traversal & recursion | `leafCount()`, `countLeaves()` |
| [`count_nodes.java`](Tree/count_nodes.java) | Counts total nodes in a binary tree | `count()`, `countTotalNodes()` |
| [`level_order.java`](Tree/level_order.java) | Breadth-First Search (BFS) level-order traversal using a Queue | `levelOrder()`, `levelOrderByLevel()` |
| [`balance_tree.java`](Tree/balance_tree.java) | Computes subtree height and validates balance factor (`|left_h - right_h| <= 1`) | `height()`, `b_f()`, `isBalanced()` |

---

## 🚶 2. Queue Module (`Queue/`)

| File | Type | Implementation | Key Highlights |
| :--- | :--- | :--- | :--- |
| [`linear_queue.java`](Queue/linear_queue.java) | Linear Queue | Static Array | Fixed-size queue showing pointer progression and reset logic |
| [`circular_queue.java`](Queue/circular_queue.java) | Circular Queue | Circular Array | Efficient index wrapping `(rear + 1) % capacity` to reuse slots |
| [`linked_list_queue.java`](Queue/linked_list_queue.java) | Linked List Queue | Singly Linked List | Dynamically sized queue with $O(1)$ operations and no fixed overflow |
| [`queue.java`](Queue/queue.java) | Circular Queue | Array | Standard circular queue implementation |

---

## 🥞 3. Stack Module (`Stack/`)

| File | Implementation | Key Operations |
| :--- | :--- | :--- |
| [`array.java`](Stack/array.java) | Array-backed fixed stack | `push()`, `pop()`, `peek()`, `isEmpty()`, `isFull()`, `size()`, `display()` |
| [`singly.java`](Stack/singly.java) | Linked-list-backed dynamic stack | `push()`, `pop()`, `peek()`, `isEmpty()`, `size()`, `display()` |

---

## 🔗 4. Linked List Module (`LinkedList/`)

| File | Implementation | Key Operations |
| :--- | :--- | :--- |
| [`singlylist.java`](LinkedList/singlylist.java) | Singly linked list | `insertAtBeginning()`, `insertAtEnd()`, `delete()`, `search()`, `display()` |
| [`doublylist.java`](LinkedList/doublylist.java) | Doubly linked list | `insertAtBeginning()`, `insertAtEnd()`, `delete()`, `displayForward()`, `displayBackward()` |

---

## 🚀 How to Compile & Run

### 1. Compile All Files
```bash
javac LinkedList/*.java Queue/*.java Stack/*.java Tree/*.java
```

### 2. Run Individual Programs
```bash
# Queue operations
java Queue.linear_queue
java Queue.circular_queue
java Queue.linked_list_queue

# Tree operations
java Tree.bst_all_operation
java Tree.count_leaf_nodes
java Tree.count_nodes
java Tree.level_order
java Tree.balance_tree

# Stack operations
java Stack.array
java Stack.singly

# Linked List operations
java LinkedList.singlylist
java LinkedList.doublylist
```

---

## 🛠️ Pushing to GitHub

```bash
# 1. Add your remote repository (replace with your repository URL)
git remote add origin https://github.com/<username>/<repository-name>.git

# 2. Push to the main branch
git push -u origin main
```
