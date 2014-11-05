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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        balanced = true;
        getDepth(root);

        return balanced;
    }
    public int getDepth(TreeNode root) {
        if (!balanced)
            return 0;
        if (root == null)
            return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1)
            balanced = false;
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
}