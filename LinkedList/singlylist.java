package LinkedList;

public class singlylist {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public singlylist() {
        this.head = null;
        this.size = 0;
    }

    // Insert at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println(data + " inserted at beginning");
    }

    // Insert at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println(data + " inserted at end");
    }

    // Delete a node by value
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty! Cannot delete.");
            return;
        }

        // If head holds the value
        if (head.data == data) {
            head = head.next;
            size--;
            System.out.println(data + " deleted from list");
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Element " + data + " not found in list");
        } else {
            current.next = current.next.next;
            size--;
            System.out.println(data + " deleted from list");
        }
    }

    // Search for a value in the list
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Display all elements
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        System.out.print("Singly Linked List: ");
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : " -> null"));
            current = current.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        singlylist list = new singlylist();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);

        list.display();

        System.out.println("Search 20: " + (list.search(20) ? "Found" : "Not Found"));
        System.out.println("Search 99: " + (list.search(99) ? "Found" : "Not Found"));

        list.delete(20);
        list.display();

        list.delete(5);
        list.display();
    }
}
