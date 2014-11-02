import java.util.*;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        postorderHelper(root, ret);
        return ret;
    }

    static void postorderHelper(TreeNode t, List<Integer> acc) {
        if (t == null) {
            return;
        }
        postorderHelper(t.left, acc);
        postorderHelper(t.right, acc);
        acc.add(t.val);
    }

    public static void main(String args[]) {
        TreeNode t = new TreeNode(1);
        t.right = new TreeNode(2);
        t.right.left = new TreeNode(3);

        List<Integer> postorder = postorderTraversal(t);
        for (int p: postorder) {
            System.out.print(p + " ");
        }
    }
}
