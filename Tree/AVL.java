package Tree;

public class AVL {
    static class Node{
        int data;
        int height;
        Node left,right;

        Node(int data){
            this.data=data;
            this.height=1;
        }
    }

    Node root;
    int height(Node root){
        if(root==null){
            return 0;
        }
        return root.height;
    }

    int balance_f(Node root){
        if(root==null)
            return 0;
        return height(root.left)-height(root.right);
    }
    Node leftrotate(Node x){
        Node y=x.right;
        Node t=y.left;
        y.left=x;
        x.right=t;
        x.height=Math.max(height(x.left),height(x.right))+1;
        y.height=Math.max(height(y.left),height(y.right))+1;
        return y;
    }

    Node rightrotate(Node y){
        Node x=y.right;
        Node t2=x.left;
        x.left=y;
        y.right=t2;
        y.height=Math.max(height(y.left),height(y.right))+1;
        x.height=Math.max(height(x.left),height(x.right))+1;
        return x;
    }

    Node insert(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(data<root.data){
            root.left=insert(root.left,data);
        }else if(data>root.data){
            root.right=insert(root.right,data);
        }else{
            return root;
        }
        root.height= 1+Math.max(height(root.left),height(root.right));
        int balance=balance_f(root);

        if(balance >1 && data <root.left.data){
            return rightrotate(root);
        }
        if(balance < -1 && data >root.right.data){
            return leftrotate(root);
        }
        if(balance >1 && data>root.left.data){
            root.left=leftrotate(root.left);
            return rightrotate(root);
        }
        if(balance <-1 && data <root.right.data){
            root.right=rightrotate(root.right);
            return leftrotate(root);
        }
        return root;
    }

    boolean bf(Node root,int data){
        if(root==null){
            return false;
        }
        int balance=balance_f(root);
        if(balance>1|| balance<-1){
            return true;
        }
        return bf(root.left,data) || bf(root.right,data);
    }

    
    void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    

   
    public static void main(String[] args) {
          AVL tree = new AVL();
        tree.root=tree.insert(tree.root, 10);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 50);
        tree.insert(tree.root, 25);
        tree.insert(tree.root, 67);
        tree.insert(tree.root, 784);
        System.out.println("Inorder traversal of constructed AVL tree:");
        tree.inOrder(tree.root);
        System.out.println();
        if(tree.bf(tree.root,0)){
            System.out.println("The tree is not balanced ");
        }else{
            System.out.println("The tree is balanced");
        }
    }
}
