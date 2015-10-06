/**
 * @created Oct 3, 2015
 * @author franklsf95
 * 
 * @problem combinations
 * @difficulty medium
 */

package leetcode;

import java.util.*;

public class Combinations {
	
	/**
	 * dfs(arr, k, m) gives all subsets of arr with k elements, with no elements greater than m
	 * arr is given by the False entries in the used array
	 * used.length == n + 1
	 */
	static void dfs(List<List<Integer>> ret, int k, int m, boolean[] used, List<Integer> sofar) {
		if (k == 0) {
			List<Integer> ans = new ArrayList<Integer>(sofar);
			Collections.reverse(ans);
			ret.add(ans);
			return;
		}
		for (int x = m; x > 0; x--) {
			if (!used[x]) {
				sofar.add(x);
				used[x] = true;
				dfs(ret, k - 1, x, used, sofar);
				sofar.remove(sofar.size() - 1);
				used[x] = false;
			}
		}
	}
	
	static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] used = new boolean[n + 1];
        dfs(ret, k, n, used, new ArrayList<Integer>());
        return ret;
    }

	public static void main(String[] args) {
		System.out.println(combine(4, 2));
		System.out.println(combine(5, 3));
		System.out.println(combine(6, 2));
	}
}
