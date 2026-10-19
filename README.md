# Data Structures & Algorithms in Java

A clean, modular repository implementing fundamental Data Structures and Algorithms in Java. Every file is self-contained with complete documentation, sample inputs, and an executable `main` method.

---

## 📁 Repository & Documentation Map

```
├── LeetCode/
│   ├── 01_Singly_Linked_Lists/       # Singly Linked List problems (LC 206, 876, 203...)
│   ├── 02_Fast_and_Slow_Pointers/    # Cycle & Pointer problems (LC 141, 142, 202...)
│   ├── 03_Reordering_and_Merging/    # Reordering & Merging (LC 21, 143, 148...)
│   ├── 04_Stack_Fundamentals/        # Stack LIFO & MinStack (LC 20, 155, 682...)
│   ├── 05_Queue_and_Deque/           # Queue, Deque, Circular Queue (LC 232, 622, 933...)
│   ├── 06_Stack_Queue_Applications/  # Monotonic stack & windowing (LC 739, 735, 394...)
│   ├── 07_Binary_Tree_Foundations/   # Traversals & Depth (LC 144, 94, 145, 102...)
│   ├── 08_Tree_Recursion/            # Balance, Diameter & Symmetry (LC 110, 543, 101...)
│   ├── 09_Tree_Views_and_Levels/     # Views, Zigzag & Width (LC 199, 103, 637...)
│   ├── 10_Tree_Paths_and_LCA/        # Paths, Sums & LCA (LC 124, 112, 236, 235...)
│   └── README.md                     # 📖 Curated LeetCode Master Tracker (80 problems)
│
├── Tree/
│   ├── bst_all_operation.java   # Complete Binary Search Tree (BST) operations
│   ├── count_leaf_nodes.java    # Count leaf nodes in BST
│   ├── count_nodes.java         # Count total nodes in BST
│   ├── level_order.java         # Level Order Traversal (BFS) using Queue
│   ├── balance_tree.java        # Height calculation & Balance factor check
│   ├── contruct_tree.java       # Binary Tree construction from Level Order
│   ├── AVL.java                 # Self-balancing AVL Tree (rotations, balance factor)
│   ├── SegmentTree.java         # Segment Tree (range sum query, point update)
│   ├── FenwickTree.java         # Binary Indexed Tree (prefix/range sums, updates)
│   ├── Heap/
│   │   └── max_heap.java        # Binary Max Heap (insert, remove, sift up/down)
│   ├── Trie/
│   │   └── trie.java            # Prefix Tree / Trie (insert, search, startsWith, delete)
│   └── README.md                # 📖 Tree Module Documentation
│
├── Graph/
│   ├── graph.java               # Weighted Undirected Graph (Adjacency List, BFS, DFS)
│   ├── union_find.java          # Disjoint Set Union (Path Compression, Rank, Components)
│   ├── practice.java            # Unweighted Graph representation
│   └── README.md                # 📖 Graph Module Documentation
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
| **LeetCode Guide** | [`LeetCode/README.md`](LeetCode/README.md) | 80 curated LeetCode problems organized into 10 topics with problem statements, solutions, and complexities. |
| **Tree Guide** | [`Tree/README.md`](Tree/README.md) | Comprehensive Tree guide: BST, Leaf/Node counting, BFS Level Order, AVL self-balancing, Segment Tree, Fenwick Tree, Max Heap, and Trie. |
| **Graph Guide** | [`Graph/README.md`](Graph/README.md) | Graph representations (Adjacency List), BFS & DFS traversals, and Disjoint Set Union (Union-Find) with path compression and rank. |
| **Queue Guide** | [`Queue/README.md`](Queue/README.md) | Linear vs Circular vs Linked List Queue comparison, $O(1)$ complexities, and circular memory reuse explanation. |
| **Stack Guide** | [`Stack/README.md`](Stack/README.md) | Array-based vs Linked-List-based Stack comparison, LIFO semantics, boundary checks, and overflow/underflow handling. |
| **Linked List Guide** | [`LinkedList/README.md`](LinkedList/README.md) | Singly vs Doubly Linked List, bidirectional traversal, pointer maintenance, and algorithmic operations. |
| **Git Ignore** | [`.gitignore`](.gitignore) | Excludes compiled `.class` binaries, `.vscode/`, `.idea/`, and temporary build artifacts. |
| **License** | [`LICENSE`](LICENSE) | MIT open source software license. |

---

## 🌳 1. Tree Module (`Tree/`)

| File | Description | Key Methods / Highlights |
| :--- | :--- | :--- |
| [`bst_all_operation.java`](Tree/bst_all_operation.java) | Comprehensive BST implementation with insert, search, delete, traversals, and balance checks | `insert()`, `search()`, `delete()`, `inorder()`, `preorder()`, `postorder()`, `min()`, `height()`, `b_f()` |
| [`count_leaf_nodes.java`](Tree/count_leaf_nodes.java) | Counts leaf nodes (`left == null && right == null`) via traversal & recursion | `leafCount()`, `countLeaves()` |
| [`count_nodes.java`](Tree/count_nodes.java) | Counts total nodes in a binary tree | `count()`, `countTotalNodes()` |
| [`level_order.java`](Tree/level_order.java) | Breadth-First Search (BFS) level-order traversal using a Queue | `levelOrder()`, `levelOrderByLevel()` |
| [`balance_tree.java`](Tree/balance_tree.java) | Computes subtree height and validates balance factor (`\|left_h - right_h\| <= 1`) | `height()`, `b_f()`, `isBalanced()` |
| [`contruct_tree.java`](Tree/contruct_tree.java) | Reconstructs binary tree from level order representation | `lvo()`, `inorder()`, `printLevelOrder()` |
| [`AVL.java`](Tree/AVL.java) | Self-balancing BST maintaining balance factor in $[-1, 1]$ via rotations | `insert()`, `leftrotate()`, `rightrotate()`, `getBF()` |
| [`SegmentTree.java`](Tree/SegmentTree.java) | Segment Tree for range sum queries and point updates in $O(\log N)$ | `seg_build()`, `query()`, `update()` |
| [`FenwickTree.java`](Tree/FenwickTree.java) | Binary Indexed Tree (BIT) with linear build and prefix/range queries | `query()`, `update()`, `rangeSum()` |
| [`Heap/max_heap.java`](Tree/Heap/max_heap.java) | Array-based Binary Max-Heap with dynamic capacity resizing | `insert()`, `remove()`, `peek()`, `heap_up()`, `heap_down()` |
| [`Trie/trie.java`](Tree/Trie/trie.java) | Prefix Tree (Trie) for dictionary string storage and prefix retrieval | `insert()`, `search()`, `startsWith()`, `delete()` |

---

## 🕸️ 2. Graph Module (`Graph/`)

| File | Type | Representation | Key Highlights |
| :--- | :--- | :--- | :--- |
| [`graph.java`](Graph/graph.java) | Weighted Undirected Graph | Adjacency List (`ArrayList<Edge>[]`) | BFS traversal (Queue), DFS traversal (Recursion), edge weight storage |
| [`union_find.java`](Graph/union_find.java) | Disjoint Set Union (DSU) | Parent & Rank arrays | Path Compression, Union by Rank, component tracking, $O(\alpha(V))$ |
| [`practice.java`](Graph/practice.java) | Unweighted Graph | Adjacency List (`ArrayList<Integer>[]`) | Fast adjacency list construction and neighbor display |

---

## 🚶 3. Queue Module (`Queue/`)

| File | Type | Implementation | Key Highlights |
| :--- | :--- | :--- | :--- |
| [`linear_queue.java`](Queue/linear_queue.java) | Linear Queue | Static Array | Fixed-size queue showing pointer progression and reset logic |
| [`circular_queue.java`](Queue/circular_queue.java) | Circular Queue | Circular Array | Efficient index wrapping `(rear + 1) % capacity` to reuse slots |
| [`linked_list_queue.java`](Queue/linked_list_queue.java) | Linked List Queue | Singly Linked List | Dynamically sized queue with $O(1)$ operations and no fixed overflow |
| [`queue.java`](Queue/queue.java) | Circular Queue | Array | Standard circular queue implementation |

---

## 🥞 4. Stack Module (`Stack/`)

| File | Implementation | Key Operations |
| :--- | :--- | :--- |
| [`array.java`](Stack/array.java) | Array-backed fixed stack | `push()`, `pop()`, `peek()`, `isEmpty()`, `isFull()`, `size()`, `display()` |
| [`singly.java`](Stack/singly.java) | Linked-list-backed dynamic stack | `push()`, `pop()`, `peek()`, `isEmpty()`, `size()`, `display()` |

---

## 🔗 5. Linked List Module (`LinkedList/`)

| File | Implementation | Key Operations |
| :--- | :--- | :--- |
| [`singlylist.java`](LinkedList/singlylist.java) | Singly linked list | `insertAtBeginning()`, `insertAtEnd()`, `delete()`, `search()`, `display()` |
| [`doublylist.java`](LinkedList/doublylist.java) | Doubly linked list | `insertAtBeginning()`, `insertAtEnd()`, `delete()`, `displayForward()`, `displayBackward()` |

---

## 🚀 How to Compile & Run

### 1. Compile All Files
```bash
javac LinkedList/*.java Queue/*.java Stack/*.java Tree/*.java Tree/Heap/*.java Tree/Trie/*.java Graph/*.java
```

### 2. Run Individual Programs
```bash
# Graph operations
java Graph.graph
java Graph.union_find
java Graph.practice

# Tree operations
java Tree.bst_all_operation
java Tree.count_leaf_nodes
java Tree.count_nodes
java Tree.level_order
java Tree.balance_tree
java Tree.contruct_tree
java Tree.AVL
java Tree.SegmentTree
java Tree.FenwickTree
java Tree.Heap.max_heap
java Tree.Trie.trie

# Queue operations
java Queue.linear_queue
java Queue.circular_queue
java Queue.linked_list_queue

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
# 1. Add changes and commit
git add .
git commit -m "Add Graph module, Trie, and enhanced Tree data structures"

# 2. Push to the main branch
git push origin main
```
