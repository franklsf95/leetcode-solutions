import java.util.*;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> acc = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                acc.add(cur.val);
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return acc;
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
