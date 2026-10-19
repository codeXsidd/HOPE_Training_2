package Tree.Trie;

/**
 * Prefix Tree / Trie Implementation in Java.
 * Supports:
 * - insert(word) in O(L)
 * - search(word) in O(L)
 * - startsWith(prefix) in O(L)
 * - delete(word) in O(L)
 */
public class trie {
    static class Node {
        Node[] c = new Node[26];
        boolean isend;
    }

    private Node root;

    public trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (temp.c[index] == null) {
                temp.c[index] = new Node();
            }
            temp = temp.c[index];
        }
        temp.isend = true;
    }
    
    public boolean search(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (temp.c[index] == null) {
                return false;
            }
            temp = temp.c[index];
        }
        return temp.isend;
    }
    
    public boolean startsWith(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (temp.c[index] == null) {
                return false;
            }
            temp = temp.c[index];
        }
        return true;
    }

    // Delete a word from the Trie. Returns true if word existed and was deleted.
    public boolean delete(String word) {
        if (!search(word)) {
            return false;
        }
        deleteHelper(root, word, 0);
        return true;
    }

    private boolean deleteHelper(Node current, String word, int index) {
        if (current == null) {
            return false;
        }
        if (index == word.length()) {
            current.isend = false;
            return isNodeEmpty(current);
        }

        char ch = word.charAt(index);
        int i = ch - 'a';
        if (current.c[i] == null) {
            return false;
        }

        boolean shouldDeleteChild = deleteHelper(current.c[i], word, index + 1);
        if (shouldDeleteChild) {
            current.c[i] = null;
            return !current.isend && isNodeEmpty(current);
        }
        return false;
    }

    private boolean isNodeEmpty(Node node) {
        for (int i = 0; i < 26; i++) {
            if (node.c[i] != null) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        trie t = new trie();
        System.out.println("--- Trie (Prefix Tree) Demonstration ---");

        System.out.println("Inserting: 'apple', 'app', 'banana', 'bat'");
        t.insert("apple");
        t.insert("app");
        t.insert("banana");
        t.insert("bat");

        System.out.println("\nSearch operations:");
        System.out.println("search('apple'): " + t.search("apple"));   // true
        System.out.println("search('app'): " + t.search("app"));       // true
        System.out.println("search('appl'): " + t.search("appl"));     // false
        System.out.println("search('banana'): " + t.search("banana")); // true
        System.out.println("search('orange'): " + t.search("orange")); // false

        System.out.println("\nPrefix (startsWith) operations:");
        System.out.println("startsWith('app'): " + t.startsWith("app")); // true
        System.out.println("startsWith('ba'): " + t.startsWith("ba"));   // true
        System.out.println("startsWith('cat'): " + t.startsWith("cat")); // false

        System.out.println("\nDelete operations:");
        System.out.println("delete('app'): " + t.delete("app"));       // true
        System.out.println("search('app') after delete: " + t.search("app")); // false
        System.out.println("search('apple') still exists: " + t.search("apple")); // true
    }
}