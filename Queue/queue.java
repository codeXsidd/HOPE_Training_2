package Queue;

public class queue {
    int a[];
    int front ;
    int rear;
    queue(int size){
        a=new int[size];
        front=0;
        rear=-1;
    }
    void enqueue(int data){
        if(rear==a.length-1){
            System.out.println("Queue overflow");
            return;
        }
        a[++rear]=data;
        System.out.println(data +" ");
    }
    int dequeue(){
        if(front==a.length-1){
            System.out.println("queue is empty");
            return -1;
        }
        int temp=a[front++];
        return temp;
    }   
    void display(){
        if(front==a.length-1){
            System.out.println("queue is empty");
            return;
        }
        for(int i=front;i<=rear;i++){
            System.out.println(a[i]);
        }
    }
    void peek(){
        if(front==a.length-1){
            System.out.println("queue is empty");
            return;
        }
        System.out.println(a[front]);
    }
    void isempty(){
        if(front==a.length-1){
            System.out.println("queue is empty");
            return;
        }
        System.out.println("queue is not empty");
    }               
    public static void main(String[] args) {
        queue q=new queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.display();
        q.dequeue();
        q.display();
        q.peek();
        q.isempty();
    }
}
