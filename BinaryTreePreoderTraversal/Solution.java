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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        if (root == null) {
            return nodeList;
        }

        TreeNode curNode = root;
        while (!nodeStack.empty() || curNode != null) {
            if (curNode != null) {
                nodeStack.push(curNode);
                nodeList.add(curNode.val);
                curNode = curNode.left;
            } else {
                curNode = nodeStack.pop().right;
            }
        }

        return nodeList;
    }
}
