package data_structures.trees;

//Recursive
public class BSTRec {
    TreeNode root;
    public BSTRec(){
        this.root = null;
    }
    public void insert(TreeNode node){
        root = insertN(root, node);
    }
    public boolean search(int data){
        return searchN(root, data);
    }
    public void delete(int data){
        if(search(data))
            root = deleteN(root, data);
        else
            System.out.println("Error: Data not Found");
    }
  
    private TreeNode insertN(TreeNode root, TreeNode node){
        /*if the TreeNode we're inserting has a value greater, move right, else move left */
        if(root == null){ // the TreeNode we're loooking at can be provided the TreeNode data
            root = node;
            return root;
        }
        else if (node.data < root.data){ 
            root.left = insertN(root.left, node);
        }
        else if (node.data > root.data){
            root.right = insertN(root.right, node);
        }
        return root;
    }
    private boolean searchN(TreeNode root, int data){
        if(root == null) // if we traverse the entire tree and find nothing, we return null
            return false;
        else if(root.data == data)
            return true;
        else if (root.data < data)
            return searchN(root.right, data);
        else
            return searchN(root.left, data);

    }
    private TreeNode deleteN(TreeNode root, int data){
        if(root == null)
            return root;
        else if (root.data < data){ 
            root.left = deleteN(root.left, data);
        }
        else if (root.data > data){
            root.right = deleteN(root.right, data);
        }
        else{ //Root.data == data meaning we found the TreeNode that we have to delete
            if(root.right == null && root.left == null){ //If there is no children for the TreeNode we can safely delete it                
                root = null;
            }
            else if (root.right != null){ // right child exists
                root.data = successor(root);
                root.right = deleteN(root.right, root.data);
            }
            else{
                root.data = predecessor(root);
                root.left = deleteN(root.left,root.data);
            }
        }
        return root;
    }
    private int successor (TreeNode root){ // find the least value below the right child of the root TreeNode
        root = root.right; // Move to the right of the root TreeNode we're looking at
        while(root.left != null){ // Look at the least value to the left in the right subtree
            root = root.left;
        }
        return root.data;
    }
    private int predecessor (TreeNode root){ // find the most value below the left child of the root TreeNode
        root = root.left; // Move to the left of the root TreeNode we're looking at
        while(root.right != null){ // Look at the greatest value to the right in the left subtree
            root = root.right;
        }
        return root.data;
    }
    /*References: 
     *  (BST) - https://www.youtube.com/watch?v=Gt2yBZAhsGM&list=PLKbzFYxJH1WQ8f9s5uSMJ3i7bH2eelVAT
     * Traversal - https://www.geeksforgeeks.org/implementing-a-binary-tree-in-java/
     */
}
