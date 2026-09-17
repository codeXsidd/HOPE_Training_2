# Linked List Data Structure Operations (Java)

This directory contains clean, modular Java implementations of Linked List variants.

---

## 📑 Implementations

| File | Type | Node Pointers | Key Highlights |
| :--- | :--- | :--- | :--- |
| [`singlylist.java`](singlylist.java) | **Singly Linked List** | `next` | Unidirectional traversal from head to tail with insertion, deletion, and search. |
| [`doublylist.java`](doublylist.java) | **Doubly Linked List** | `prev`, `next` | Bidirectional traversal with `head` and `tail` pointers. Enables efficient forward and backward operations. |

---

## ⏱️ Complexity Comparison

| Operation | Singly Linked List | Doubly Linked List |
| :--- | :--- | :--- |
| **Insert at Beginning** | $O(1)$ | $O(1)$ |
| **Insert at End** | $O(N)$ (without tail) / $O(1)$ (with tail) | $O(1)$ (using tail) |
| **Delete by Value** | $O(N)$ | $O(N)$ |
| **Search** | $O(N)$ | $O(N)$ |
| **Traversal Direction** | Forward only | Bidirectional (Forward & Backward) |

---

## 💻 How to Compile & Run

From the root project directory:

```bash
# Compile linked list files
javac LinkedList/*.java

# Run Singly Linked List
java LinkedList.singlylist

# Run Doubly Linked List
java LinkedList.doublylist
```
