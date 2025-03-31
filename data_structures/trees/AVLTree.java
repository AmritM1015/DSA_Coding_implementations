package data_structures.trees;
//TODO:

public class AVLTree{
    public class TreeNode { // Similar to the TreeNode class but it has a height variable
        public int data,height;
        public TreeNode right,left,parent;
        public TreeNode(int data){
            this.data = data;
            this.parent = null;
            this.right = null;
            this.left = null;
            this.height = 0;        
        }
    }
    private TreeNode root;
    public AVLTree(){
        this.root = null;
    }
    public TreeNode getRoot(){
        return root;
    }
    public boolean isExternal(TreeNode v){
        return v.right == null && v.left == null;
    }
    public void TreeInsert(int k){
        TreeNode node = new TreeNode(k);
        if(root == null){
            root = node;
            return;
        }
        TreeNode w = root;
        TreeNode p = null;
        while(w!=null){
            p = w;
            if (k < w.data)
                w = w.left;
            else
                w = w.right;
        }
        if (p != null) { //This if statement isnt actually needed but VSCode kept giving me null pointer warnings so I had to do this
            node.parent = p;
            if (k < p.data)
                p.left = node;
            else
                p.right = node;
        }
        TreeNode curr = node;
        while(curr != null){
            updateHeight(curr);
            curr = balanceTree(curr);
            curr = curr.parent;
        }

    }
    public void TreeDelete(int k){
        TreeNode w = root;
        TreeNode parent = null;
        while (w!= null && w.data != k){
            parent = w;
            if (k < w.data)
                w = w.left;
            else
                w=w.right;
        }
        if (w==null){
            System.err.println("Value not found in the BST");
            return;
        }
        if(isExternal(w))
            DeleteExternal(parent,w);
        else if (w.left == null ^ w. right == null){
            DeleteOneChild(parent,w);
        }
        else
            DeleteTwoChildren(parent,w);
        TreeNode curr = parent;
        while(curr != null){
            updateHeight(curr);
            curr = balanceTree(curr);
            curr = curr.parent;
        }
    }
    public int height(TreeNode node){
        if(node == null)
            return -1;
        return node.height;
    }
    private void updateHeight(TreeNode v){
        v.height = 1 + Math.max(height(v.left),height(v.right));
    }
    private int BalanceFactor(TreeNode v){
        if(v == null){
            return 0;
        }
        return height(v.left)-height(v.right);
    }
    private TreeNode balanceTree(TreeNode v){
        int balance = BalanceFactor(v);
        if(balance > 1 && BalanceFactor(v.left)>= 0)
            return rotateRight(v);
        if(balance < -1 && BalanceFactor(v.right)<= 0)
            return rotateLeft(v);
        if(balance > 1 && BalanceFactor(v.left)<= 0){
            v.left = rotateLeft(v.left);
            return rotateRight(v);
        }
        if(balance < -1 && BalanceFactor(v.right)> 0){
            v.right = rotateRight(v.right);
            return rotateLeft(v);
        }
        return v;
        
    }
    private TreeNode rotateLeft(TreeNode x){
        TreeNode y = x.right;
        TreeNode T2 = y.left;
        
        //Rotation
        y.left = x;
        x.right = T2;
        //Update Parents
        y.parent = x.parent;
        x.parent = y;
        if(T2 != null)
            T2.parent = x;
        //Fix connection from above
        if(y.parent == null){
            root = y;
        }
        else if(y.parent.left == x){
            y.parent.left = y;
        }
        else
            y.parent.right = y;
        //Update Heights
        x.height= 1+ Math.max(height(x.left),height(x.right));
        y.height= 1+ Math.max(height(y.left),height(y.right));

        return y;
    }
    private TreeNode rotateRight(TreeNode y){
        TreeNode x = y.left;
        TreeNode T2 = x.right;
        
        //Rotation
        x.right = y;
        y.left = T2;
        //Update Parents
        x.parent = y.parent;
        y.parent = x;
        if(T2 != null)
            T2.parent = y;
        //Fix Connection from above
        if(x.parent == null)
            root = x;
        else if (x.parent.left == y)
            x.parent.left = x;
        else
            x.parent.right = x;
        //Update Heights
        y.height= 1+ Math.max(height(y.left),height(y.right));
        x.height= 1+ Math.max(height(x.left),height(x.right));

        return x;
    }
    public void DeleteExternal(TreeNode parent, TreeNode w){
        if (parent == null) {
            root = null;
            return;
        }    
        if(parent.left!= null && parent.left == w){
            parent.left = null;
        }
        else
            parent.right = null;

    }
    public void DeleteOneChild(TreeNode parent, TreeNode w){
        TreeNode child;
        if(w.left == null) //w has one right child
            child = w.right;
        else
            child = w.left; //w has one left child
        if(parent.left == w)
            parent.left = child; //If w is to the left of the parent, we replace it with the successor
        else
            parent.right = child; // If w is to the right of the parent, we replace it with the successor
        child.parent = parent; //Linking the child completely to the parent 
    }
    public void DeleteTwoChildren(TreeNode parent, TreeNode w) {
        TreeNode v_p = w;           // Parent of successor
        TreeNode v = w.right;       // Start at right subtree
    
        // Find in-order successor (leftmost node in right subtree)
        while (v.left != null) {
            v_p = v;
            v = v.left;
        }
    
        if (v_p != w) {
            // You have to make sure that v_p is not w or else it will throw a null pointer exception
            v_p.left = v.right;
            v.right = w.right;
        }
    
        v.left = w.left;
    
        // Link v to parent of w
        if (parent == null) {
            root = v; // Special case: w is root
        } else if (parent.left == w) {
            parent.left = v;
        } else {
            parent.right = v;
        }
    
        System.out.println("Deleted node with two children: " + w.data);
    }
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
    
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}
