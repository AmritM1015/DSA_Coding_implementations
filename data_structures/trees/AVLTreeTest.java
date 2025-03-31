package data_structures.trees;

public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values)
            avl.TreeInsert(v);

        System.out.println("=== AVL Tree Insertion ===");
        System.out.print("In-order: ");
        avl.inOrder(avl.getRoot());
        System.out.println();

        // Check searches
        // System.out.println("Search 40: " + avl.TreeSearch(avl.getRoot(), 40)); // true
        // System.out.println("Search 100: " + avl.TreeSearch(avl.getRoot(), 100)); // false

        AVLTree.TreeNode root = avl.getRoot();
        System.out.println("Is root balanced? Root = " + root.data + ", Height = " + avl.height(root));

        // Delete a leaf
        avl.TreeDelete(20);
        System.out.println("After deleting 20:");
        avl.inOrder(avl.getRoot());

        // Delete node with one child
        avl.TreeDelete(30);
        System.out.println("\nAfter deleting 30:");
        avl.inOrder(avl.getRoot());

        // Delete node with two children
        avl.TreeDelete(50);
        System.out.println("\nAfter deleting 50:");
        avl.inOrder(avl.getRoot());

        System.out.println("\nNew root after deletions: " + avl.getRoot().data);

        System.out.println("\n=== Final Traversals ===");
        
        System.out.print("In-order: ");
        avl.inOrder(avl.getRoot());
        System.out.println(); // new line
        
        System.out.print("Pre-order: ");
        avl.preOrder(avl.getRoot());
        System.out.println();

        System.out.print("Post-order: ");
        avl.postOrder(avl.getRoot());
        System.out.println();
    }
}
