package data_structures.trees;
public class TreeTraversals {
    public void preOrder(TreeNode v){
        if(v != null){
            System.out.print(v.data + " "); //perform visit action for node v
            preOrder(v.left);
            preOrder(v.right);
        }
    }
    public void inOrder(TreeNode v){
        if(v != null){
            inOrder(v.left);
            System.out.print(v.data + " ");//perform visit action for node v
            inOrder(v.right);
        }
    }
    public void postOrder(TreeNode v){
        if(v != null){
            postOrder(v.left);
            postOrder(v.right);
            System.out.print(v.data + " ");//perform visit action for node v
        }
    }

}
