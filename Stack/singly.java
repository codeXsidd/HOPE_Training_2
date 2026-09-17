package Stack;

public class singly {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    singly() {
        top = null;
        size = 0;
    }

    // Push: Insert element at the top of the stack
    public void push(int data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
        size++;
        System.out.println(data + " pushed onto stack");
    }

    // Pop: Remove and return the top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Stack is empty.");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        size--;
        return popped;
    }

    // Peek: Return the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Return the size of the stack
    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        Node current = top;
        System.out.print("Stack (top -> bottom): ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the stack
    public static void main(String[] args) {
        singly stack = new singly();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.display();

        System.out.println("Top element (peek): " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        stack.display();

        System.out.println("Stack size: " + stack.size());
        System.out.println("Is empty: " + stack.isEmpty());
    }
}
