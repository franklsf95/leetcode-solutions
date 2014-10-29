import java.util.*;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        preorderHelper(root, ret);
        return ret;
    }

    static void preorderHelper(TreeNode t, List<Integer> acc) {
        if (t == null) {
            return;
        }
        acc.add(t.val);
        preorderHelper(t.left, acc);
        preorderHelper(t.right, acc);
    }

    public static void main(String args[]) {
        TreeNode t = new TreeNode(1);
        t.right = new TreeNode(2);
        t.right.left = new TreeNode(3);

        List<Integer> preorder = preorderTraversal(t);
        for (int p: preorder) {
            System.out.print(p + " ");
        }
    }
}
