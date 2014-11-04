/**
 * @created Oct 29, 2014
 * @author franklsf95
 * 
 * @problem binary-tree-preorder-traversal
 * @difficulty medium
 */

package leetcode;

import java.util.*;

public class BinaryTreePreorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Iterative traversal
     */
    static List<Integer> preorderTraversalIterative(TreeNode root) {
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
    
    /**
     * Recursive traversal
     */
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

        preorder = preorderTraversalIterative(t);
        for (int p: preorder) {
            System.out.print(p + " ");
        }
    }

}
