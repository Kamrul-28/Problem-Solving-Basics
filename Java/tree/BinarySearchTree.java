import java.util.*;

class Main{
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        List<String> list = Arrays.asList("10", "7", "14", "20", "1", "5", "8");
        for(String s : list){
            bst.insert(Integer.parseInt(s));
        }
        bst.InOrder(bst.root);
        System.out.println();
        bst.PreOrder(bst.root);
        System.out.println();
        bst.PostOrder(bst.root);
    }
}

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BinarySearchTree{
    TreeNode root;
    
    public void insert(int data){
        TreeNode newNode = new TreeNode(data);
        if(root == null){
            root = newNode;
            return;
        }else{
            TreeNode current = root, parent = null;
            while(true) {
                //parent keep track of the parent node of current node.
                parent = current;

                //If data is less than current's data, node will be inserted to the left of tree
                if(data < current.data) {
                    current = current.left;
                    if(current == null) {
                        parent.left = newNode;
                        return;
                    }
                }
                //If data is greater than current's data, node will be inserted to the right of tree
                else {
                    current = current.right;
                    if(current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    public void InOrder(TreeNode node){
        if(node == null){
            return;
        }
        InOrder(node.left);
        System.out.print(node.data + " ");
        InOrder(node.right);
    }
    
    public void PreOrder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        PreOrder(node.left);
        PreOrder(node.right);
    }
    
    public void PostOrder(TreeNode node){
        if(node == null){
            return;
        }
        PostOrder(node.left);
        PostOrder(node.right);
        System.out.print(node.data + " ");
    }
    
}