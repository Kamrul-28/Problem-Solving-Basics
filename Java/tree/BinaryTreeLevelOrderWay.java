import java.util.*;
class Main{
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        List<String> arr = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
        for(String s : arr){
            bt.insert(Integer.parseInt(s));
        }

        bt.preOrder(bt.root);
        System.out.println();
        bt.inOrder(bt.root);
        System.out.println();
        bt.postOrder(bt.root);
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree{
    TreeNode root;

    public void insert(int value){
        TreeNode newNode = new TreeNode(value);
        if(root == null){
            root = newNode;
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tempNode = queue.poll();

            // If the left child is empty, create a new node and assign the data
            if (tempNode.left == null) {
                tempNode.left = newNode;
                break;
            } else { // If the left child is not empty, enqueue it
                queue.add(tempNode.left);
            }

            // If the right child is empty, create a new node and assign the data
            if (tempNode.right == null) {
                tempNode.right = newNode;
                break;
            } else { // If the right child is not empty, enqueue it
                queue.add(tempNode.right);
            }
        }
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.value + " ");
        postOrder(root.left);
        postOrder(root.right);
    }
}