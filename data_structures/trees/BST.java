package data_structures.trees;
import data_structures.queues.Deque;
//Iterative
/*
 * Search, Insert Delete Runtime: O(d) where d is depth of the tree 
 */
public class BST{
    TreeNode root;
    public BST(){
        this.root = null;
    }
    public TreeNode getRoot(){
        return root;
    }
    public boolean isInternal(TreeNode v){
        return v.right != null || v.left != null;
    }
    public boolean isExternal(TreeNode v){
        return v.right == null && v.left == null;
    }
    public boolean isRoot(TreeNode v){
        return v == root;
    }
    public TreeNode sibling(TreeNode v){
        if(v == null || v.parent == null)
            return null;
        if(v.parent.left != null)
            return v.parent.left;
        else
            return v.parent.right;
    }
    public int depth(TreeNode v){
        if(v == root)
            return 0;
        else
            return 1+ depth(v.parent);
    }
    public int depthIterative(TreeNode v){
        if(v == null)
            return 0;
        Deque<NodeDepthPair> queue = new Deque<>();
        queue.addLast(new NodeDepthPair(v, 0));
        int m = 0;
        while(!queue.isEmpty()){
            NodeDepthPair pair = queue.popLeft();
            TreeNode node = pair.node;
            int depth = pair.depth;
            if(node != null){
                m = Math.max(m, depth);
                if(node.left!= null)
                    queue.addLast(new NodeDepthPair(node.left, depth+1));
                if(node.right!= null)
                    queue.addLast(new NodeDepthPair(node.right, depth+1));
            }

        }
        return m;
    }
    public int height(TreeNode v){
        if(isExternal(v))
            return 0;
        else
            return 1+Math.max(height(v.left),height(v.right));
    }
    public boolean TreeSearch(TreeNode v, int data){
        if(v == null)
            return false;
        if(data == v.data)
            return true;
        else if (data > v.data)
            return TreeSearch(v.right, data);
        else
            return TreeSearch(v.left, data);     
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
        node.parent = p;
        if (p != null) { //This if statement isnt actually needed but VSCode kept giving me null pointer warnings so I had to do this
            node.parent = p;
            if (k < p.data)
                p.left = node;
            else
                p.right = node;
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
    public void leafSeq(TreeNode root){
        if (root == null)
            return;
        if(root.left == null && root.right == null){
            System.out.print(root.data+" ");
        }
        else{
            leafSeq(root.left);
            leafSeq(root.right);
        }
    }
}
