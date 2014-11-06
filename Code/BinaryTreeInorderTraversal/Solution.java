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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (root != null)
            inorderTraversal(root, list);
        
        return list;
    }
    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root.left != null)
            inorderTraversal(root.left, list);
        list.add(root.val);
        if (root.right != null) 
            inorderTraversal(root.right, list);

    }
}