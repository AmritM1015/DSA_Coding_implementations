package data_structures.trees;

public class TreeNode { // Note:Only for BST, traversals and small trees
    public int data;
    public TreeNode right;
    public TreeNode left;
    public TreeNode parent;
    public TreeNode(int data){
        this.data = data;
        this.parent = null;
        this.right = null;
        this.left = null;        
    }
}
