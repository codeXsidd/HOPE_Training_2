package Queue;

/**
 * Queue Implementation using a Singly Linked List.
 * Dynamic size: Grows and shrinks as needed without fixed capacity overflow.
 * Enqueue at rear (O(1)), Dequeue from front (O(1)).
 */
public class linked_list_queue {
    // Node structure for linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    // Constructor to initialize empty queue
    public linked_list_queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue: Add an element to the rear of the queue (O(1))
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("[ENQUEUED] " + data + " | current size: " + size);
    }

    // Dequeue: Remove and return the front element (O(1))
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("[UNDERFLOW] Queue is empty.");
            return -1;
        }
        int removed = front.data;
        front = front.next;

        // If front becomes null, rear must also be reset to null
        if (front == null) {
            rear = null;
        }
        size--;
        System.out.println("[DEQUEUED] " + removed + " | remaining size: " + size);
        return removed;
    }

    // Peek: View front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("[INFO] Queue is empty.");
            return -1;
        }
        return front.data;
    }

    // Return the number of elements
    public int size() {
        return size;
    }

    // Display all elements from front to rear
    public void display() {
        if (isEmpty()) {
            System.out.println("[QUEUE] Currently empty.");
            return;
        }
        Node current = front;
        System.out.print("[QUEUE] (front -> rear): ");
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : " -> null"));
            current = current.next;
        }
        System.out.println();
    }

    // Main method to demonstrate Linked List Queue
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("    LINKED LIST QUEUE DEMONSTRATION     ");
        System.out.println("========================================");

        linked_list_queue q = new linked_list_queue();

        // Enqueue elements dynamically
        q.enqueue(100);
        q.enqueue(200);
        q.enqueue(300);
        q.enqueue(400);

        System.out.println();
        q.display();

        System.out.println("\n[PEEK] Front element: " + q.peek());
        System.out.println("[SIZE] Size of queue: " + q.size());

        System.out.println("\n--- Performing Dequeue Operations ---");
        q.dequeue();
        q.dequeue();

        System.out.println();
        q.display();

        System.out.println("\n--- Enqueuing More Elements ---");
        q.enqueue(500);
        q.enqueue(600);

        System.out.println();
        q.display();
        System.out.println("[PEEK] Front element now: " + q.peek());
        System.out.println("[SIZE] Final size: " + q.size());
    }
}
