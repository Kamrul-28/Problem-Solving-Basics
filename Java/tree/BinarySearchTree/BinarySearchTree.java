package BinarySearchTree;

public class BinarySearchTree {
    static class  Node{
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root,int value){
        if(root == null){
            root = new Node(value);
            return root;
        }

        if(root.data > value){
            root.left = insert(root.left, value);
        }else{
            root.right = insert(root.right, value);
        }

        return root;
    }
    
    public static void inorder(Node root){
        if(root==null){
            return ;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Boolean search(Node root,int data){
        if(root == null){
            return false;
        }
        if(root.data == data){
            return true;
        }
        if(root.data > data){
            return search(root.left, data);
        }else{
            return search(root.right, data);
        }
    }

    public static Node deleteNode(Node root, int key) {
        if(root==null){
            return root;
        }
         if(root.data<key){
             root.right= deleteNode(root.right,key);
         }else if(root.data>key){
             root.left= deleteNode(root.left,key);
         }else{
            //Case 1
             if(root.right==null && root.left==null){
                 return null;
             }

             //Case 2
             if(root.left==null){
                 return root.right;
             }
             if(root.right==null){
                 return root.left;
             }
             
             //Case 3
             Node IS= inorderSuccessor(root.right);
             root.data= IS.data;
             root.right= deleteNode(root.right, IS.data);
         }
         return root;
     }

    public static Node inorderSuccessor(Node root){
        while(root.left!=null){
            root= root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        for(int value:values){
            root = insert(root, value);
        }
        inorder(root);
        System.out.println();
        System.out.println("Search Result: " + search(root, 6));
        deleteNode(root,4);
        inorder(root);
    }

}
