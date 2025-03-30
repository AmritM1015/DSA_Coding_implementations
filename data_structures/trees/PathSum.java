package data_structures.trees;

/*
 * The problem presents a binary tree where each node contains an integer value. 
 * The goal is to find out if there is a path from the root node down to any leaf node 
 * such that the sum of the values of all the nodes along the path is equal to 
 * the given integer targetSum. A leaf node is defined as a node that does not 
 * have any children. If such a path exists, the function should return true; 
 * otherwise, it should return false.
 */
public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum){
        return DFS(root, 0, targetSum);
    }
    private static boolean DFS(TreeNode root, int s, int targetSum){
        if(root == null){
            return false;
        }
        s+= root.data;
        if(root.left == null && root.right == null && s == targetSum){
            return true;
        }
        return (DFS(root.left, s, targetSum) || DFS(root.right, s, targetSum));
    }   
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        /*Tree Structure:
         *    5
            /   \
           4     8
          /     / \
         11    13  4
        /  \         \
       7    2         1

         */

        System.out.println("Has Path Sum 22: " + hasPathSum(root, 22));  // true
        System.out.println("Has Path Sum 26: " + hasPathSum(root, 26));  // true
        System.out.println("Has Path Sum 18: " + hasPathSum(root, 18));  // true
        System.out.println("Has Path Sum 100: " + hasPathSum(root, 100));  // true

    } 
    //Reference: https://algo.monster/liteproblems/112
}
