package data_structures.trees;

public class TreeTest {
    public static void main(String[] args) {
        BST tree = new BST();

        // Insertion
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values)
            tree.TreeInsert(v);
        /*
         *        50
                 /  \
               30    70
              /  \   / \
             20  40 60  80

         */
        // Check TreeSearch
        System.out.println("Search 40: " + tree.TreeSearch(tree.getRoot(), 40)); // true
        System.out.println("Search 100: " + tree.TreeSearch(tree.getRoot(), 100)); // false

        // Check root
        TreeNode root = tree.getRoot();
        System.out.println("Is root 50? " + (root.data == 50));

        // Check internal & external
        TreeNode node40 = root.left.right; // 40
        TreeNode node20 = root.left.left;  // 20 (should be leaf)
        System.out.println("Is 40 internal? " + tree.isInternal(node40)); // false
        System.out.println("Is 20 external? " + tree.isExternal(node20)); // true

        // Check sibling
        System.out.println("Sibling of 40: " + tree.sibling(node40).data); // Should be 20

        // Check depth and height
        System.out.println("Depth of node 40: " + tree.depth(node40)); // 2
        System.out.println("Height of root: " + tree.height(root)); // 2

        // Delete external node (leaf)
        tree.TreeDelete(20);
        System.out.println("After deleting 20:");
        System.out.println("Search 20: " + tree.TreeSearch(tree.getRoot(), 20)); // false
        /*
         *        50
                 /  \
               30    70
                 \   / \
                 40 60  80
         */
        // Delete node with one child (let’s remove 30)
        tree.TreeDelete(30);
        System.out.println("After deleting 30:");
        System.out.println("Search 30: " + tree.TreeSearch(tree.getRoot(), 30)); // false
        /*
         *        50
                 /  \
               40    70
                     / \
                    60  80
         */
        // Delete node with two children (50)
        tree.TreeDelete(50);
        System.out.println("After deleting 50:");
        System.out.println("Search 50: " + tree.TreeSearch(tree.getRoot(), 50)); // false
        System.out.println("New root: " + tree.getRoot().data);
        /*
         *        60
                 /  \
               40    70
                       \
                        80
         */

        // Add after building the tree and inserting nodes
        TreeTraversals traversal = new TreeTraversals();

        System.out.println("\n=== Traversals ===");

        // In-order traversal: should print sorted keys
        System.out.print("In-order: ");
        traversal.inOrder(tree.getRoot());
        System.out.println(); // new line

        // Pre-order traversal
        System.out.print("Pre-order: ");
        traversal.preOrder(tree.getRoot());
        System.out.println();

        // Post-order traversal
        System.out.print("Post-order: ");
        traversal.postOrder(tree.getRoot());
        System.out.println();
    }
}
