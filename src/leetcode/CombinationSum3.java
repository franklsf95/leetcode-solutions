/**
 * @created Oct 3, 2015
 * @author franklsf95
 * 
 * @problem combination-sum-iii
 * @difficulty medium
 */

package leetcode;

import java.util.*;

public class CombinationSum3 {
	
	/**
	 * dfs(T, n, m) gives all combinations with n elements that sum up to T, with no element greater than m
	 */
	static void dfs(List<List<Integer>> ret, int T, int n, int m, boolean[] used, List<Integer> sofar) {
		if (T == 0) {
			if (n == 0) {
				List<Integer> ans = new ArrayList<Integer>(sofar);
				Collections.reverse(ans);
				ret.add(ans);
			}
			// If T == 0 but n != 0, fail
			return;
		}
		// If T != 0 but n == 0, fail
		if (n == 0) {
			return;
		}
		if (m > T) {
			m = T;
		}
		for (int k = Math.min(m, 9); k > 0; k--) {
			if (!used[k]) {
				sofar.add(k);
				used[k] = true;
				dfs(ret, T - k, n - 1, k, used, sofar);
				sofar.remove(sofar.size() - 1);
				used[k] = false;
			}
		}
	}
	
	static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] used = new boolean[10];
        dfs(ret, n, k, n, used, new ArrayList<Integer>());
        return ret;
    }

	public static void main(String[] args) {
		System.out.println(combinationSum3(3, 7));
		System.out.println(combinationSum3(3, 9));
		System.out.println(combinationSum3(3, 15));
	}
}
