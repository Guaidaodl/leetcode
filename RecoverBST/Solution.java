public class Solution {
    TreeNode bigError;
    TreeNode smallError;
    TreeNode preNode;
    public void recoverTree(TreeNode root) {
        bigError = null;
        smallError = null;
        preNode = null;
        inOrderTraversal(root);
        int t = bigError.val;
        bigError.val = smallError.val;
        smallError.val = t;
    }
    public void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        if (preNode != null) {
            if (root.val < preNode.val) {
                if (bigError == null)
                    bigError = preNode;
                smallError = root;
            }
        }
        preNode = root;
        inOrderTraversal(root.right);
    }
}