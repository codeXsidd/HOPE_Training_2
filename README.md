# Data Structures & Algorithms in Java

A structured repository implementing fundamental Data Structures and Algorithms in Java, cleanly organized into topic-specific modules.

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
│   ├── array.java               # Stack implementation using Array
│   └── singly.java              # Stack implementation using Singly Linked List
│
├── Queue/
│   └── queue.java               # Queue implementation
│
├── LinkedList/
│   ├── singlylist.java          # Singly Linked List implementation
│   └── doublylist.java          # Doubly Linked List implementation
│
├── .gitignore                   # Ignores compiled .class files and IDE configs
└── README.md                    # Project documentation
```

---

## 🌳 Tree Module (`Tree/`)

The `Tree/` directory provides modular implementations of Binary Search Tree (BST) operations:

| File | Description | Key Methods |
| :--- | :--- | :--- |
| [`bst_all_operation.java`](Tree/bst_all_operation.java) | All-in-one BST implementation covering standard operations | `insert()`, `search()`, `delete()`, `inorder()`, `preorder()`, `postorder()`, `min()`, `height()`, `b_f()` |
| [`count_leaf_nodes.java`](Tree/count_leaf_nodes.java) | Counts nodes that have 0 children (both left & right are `null`) | `leafCount()`, `countLeaves()` |
| [`count_nodes.java`](Tree/count_nodes.java) | Counts total number of nodes present in the tree | `count()`, `countTotalNodes()` |
| [`level_order.java`](Tree/level_order.java) | Breadth-First Search (BFS) level order traversal using a FIFO Queue | `levelOrder()`, `levelOrderByLevel()` |
| [`balance_tree.java`](Tree/balance_tree.java) | Computes tree height and verifies if the tree satisfies height-balance criteria | `height()`, `b_f()`, `isBalanced()` |

For full code explanations and examples, check out the [`Tree/README.md`](Tree/README.md).

---

## 📚 Other Modules

- **Stack (`Stack/`)**:
  - `array.java`: Fixed-size stack with push, pop, peek, and overflow/underflow handling.
  - `singly.java`: Dynamic stack backed by singly-linked nodes.
- **Queue (`Queue/`)**:
  - `queue.java`: First-In-First-Out (FIFO) queue operations.
- **Linked List (`LinkedList/`)**:
  - `singlylist.java`: Singly-linked list node and operations.
  - `doublylist.java`: Doubly-linked list with bidirectional pointers.

---

## 🚀 Getting Started

### Prerequisites
- **Java Development Kit (JDK 8 or higher)** installed.
- Verify installation:
  ```bash
  javac -version
  java -version
  ```

### How to Compile & Run

You can compile and run any file from the project root:

#### 1. Compile All Tree Programs
```bash
javac Tree/*.java
```

#### 2. Run Individual Operations
```bash
# Run All-in-one BST Operations
java Tree.bst_all_operation

# Run Leaf Node Counter
java Tree.count_leaf_nodes

# Run Total Node Counter
java Tree.count_nodes

# Run Level Order (BFS) Traversal
java Tree.level_order

# Run Balance Tree / Height Check
java Tree.balance_tree
```

---

## 🛠️ GitHub Push Instructions

If you are pushing this repository to GitHub for the first time:

1. **Initialize Git repository**:
   ```bash
   git init
   ```
2. **Stage all files**:
   ```bash
   git add .
   ```
3. **Commit changes**:
   ```bash
   git commit -m "Organize tree operations into modular files and add documentation"
   ```
4. **Link to your GitHub remote repository**:
   ```bash
   git branch -M main
   git remote add origin https://github.com/<your-username>/<your-repo-name>.git
   ```
5. **Push to GitHub**:
   ```bash
   git push -u origin main
   ```
