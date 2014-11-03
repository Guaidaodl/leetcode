
public class Solution {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (!isSameNode(p, q))
            return false;
        if (p == null)
            return true;
        if (!isSameTree(p.left, q.left))
            return false;
        if (!isSameTree(p.right, q.right))
            return false;

        return true;
    }
    public static boolean isSameNode(TreeNode p, TreeNode q) {
        if (p == null && q != null)
            return false;
        if (p != null && q == null)
            return false;
        if (p != null && q != null && p.val != q.val)
            return false;

        return true;
    }
    public static void main(String []args) {
        System.out.println(isSameTree(null, null));
        System.out.println(isSameTree(new TreeNode(0), new TreeNode(0)));

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        p.right = new TreeNode(2);

        System.out.println(isSameTree(p, q));
    }
}