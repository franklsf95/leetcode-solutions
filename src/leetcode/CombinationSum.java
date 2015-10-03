/**
 * @created Oct 3, 2015
 * @author franklsf95
 * 
 * @problem combination-sum
 * @difficulty medium
 */

package leetcode;

import java.util.*;

public class CombinationSum {
	
	/**
	 * dfs(T, m) gives all combinations from arr that sum to T, with no items greater than m
	 * arr must be in non-descending order
	 */
	static void dfs(List<List<Integer>> ret, int T, int m, int[] arr, List<Integer> sofar) {
		if (T == 0) {
			if (sofar.size() > 0) {
				List<Integer> ans = new ArrayList<Integer>(sofar);
				Collections.reverse(ans);
				ret.add(ans);
			}
			return;
		}
		// Starting from the large elements
		for (int i = arr.length - 1; i >= 0; i--) {
			int x = arr[i];
			if (x <= m && x <= T) {
				sofar.add(x);
				dfs(ret, T - x, x, arr, sofar);
				sofar.remove(sofar.size() - 1);
			}
		}
	}
	
	static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
		dfs(ret, target, target, candidates, new ArrayList<Integer>());
		return ret;
    }

	public static void main(String[] args) {
		int[] arr = {2, 3, 6, 7};
		System.out.println(combinationSum(arr, 7));
		int[] brr = {1, 2, 3, 5, 7};
		System.out.println(combinationSum(brr, 10));
	}
}
