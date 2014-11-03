/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int l = 1 + maxDepth(root.left);
        int r = 1 + maxDepth(root.right);
        
        return l > r ? l : r; 
    }
    public static void main(String []args) {
    	TreeNode tree = new TreeNode(1);
    	System.out.println(maxDepth(tree));	
    }
}

