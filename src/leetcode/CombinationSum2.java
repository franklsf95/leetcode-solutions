/**
 * @created Oct 3, 2015
 * @author franklsf95
 * 
 * @problem combination-sum-ii
 * @difficulty medium
 */

package leetcode;

import java.util.*;

public class CombinationSum2 {
	
	static long h(int T, List<Integer> lst) {
		long ret = 0;
		for (int x: lst) {
			ret = ret * (T + 1) + x;
		}
		return ret;
	}
	
	/**
	 * dfs(T, m) gives all combinations from arr that sum to T, with no items greater than m
	 * arr must be in non-descending order
	 */
	static void dfs(List<List<Integer>> ret, int originalT, int T, int m, int[] arr, boolean[] used, List<Integer> sofar, List<Long> hashes) {
		if (T == 0) {
			if (sofar.size() > 0) {
				// Check hash
				long hash = h(originalT, sofar);
				if (hashes.indexOf(hash) == -1) {
					// A new combination!
					List<Integer> ans = new ArrayList<Integer>(sofar);
					Collections.reverse(ans);
					ret.add(ans);
					hashes.add(hash);
				}
			}
			return;
		}
		// Starting from the large elements
		for (int i = arr.length - 1; i >= 0; i--) {
			int x = arr[i];
			if (!used[i] && x <= m && x <= T) {
				sofar.add(x);
				used[i] = true;
				dfs(ret, originalT, T - x, x, arr, used, sofar, hashes);
				sofar.remove(sofar.size() - 1);
				used[i] = false;
			}
		}
	}
	
	static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
		dfs(ret, target, target, target, candidates, used, new ArrayList<Integer>(), new ArrayList<Long>());
		return ret;
    }

	public static void main(String[] args) {
		int[] arr = {10,1,2,7,6,1,5};
		System.out.println(combinationSum2(arr, 8));
	}
}
