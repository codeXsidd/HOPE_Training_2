package Stack;

public class array-operation {
     class stack{
        int top;
        stack(int data){
            a=new int[data];
            top=-1;
        }
        void push(int data){
            if(top==a.length){
                System.out.println("Stack Overflow");
            }
            top++;
            a[top]=data;
        }
        int pop(){
            if(top==a.length-1){
                System.out.println("Stack Underflow");
            }
            top--;
            return a[top];
        }
        void display(){
            for(int i=0;i<=top;i++){
                System.out.println(a[i]);
            }
        }
        void isempty(){

        }
     }
     public static void main(String[] args){
        
     }

}
