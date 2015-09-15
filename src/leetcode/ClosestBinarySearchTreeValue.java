/**
 * @created Sep 7, 2015
 * @author franklsf95
 * 
 * @problem closest-binary-search-tree-value
 * @difficulty easy
 */

package leetcode;

import java.util.*;

public class ClosestBinarySearchTreeValue {
	
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	static int closestValue(TreeNode root, double target) {
        double[] ans = {Double.MAX_VALUE, 0};
        // [0] min diff; [1] min value
        closestValueHelper(root, target, ans);
        return (int)ans[1];
    }
	
	static void closestValueHelper(TreeNode root, double target, double[] ans) {
		if (root == null) {
			return;
		}
        double diff = Math.abs(root.val - target);
        if (diff < ans[0]) {
        	ans[0] = diff;
        	ans[1] = root.val;
        }
        if (diff < 0.0000001) {
        	return;
        }
        closestValueHelper(root.left, target, ans);
        closestValueHelper(root.right, target, ans);
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t4.left = t2;
		t4.right = t5;
		t2.left = t1;
		t2.right = t3;
		t5.right = t6;
		System.out.println(closestValue(t4, 3.14));
		System.out.println(closestValue(t4, 3.99));
		System.out.println(closestValue(t4, 4.99));
		System.out.println(closestValue(t4, 10.25));
	}

}
