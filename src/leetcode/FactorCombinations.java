/**
 * @created Oct 3, 2015
 * @author franklsf95
 * 
 * @problem factor-combinations
 * @difficulty medium
 */

package leetcode;

import java.util.*;

public class FactorCombinations {
	
	/**
	 * dfs(n, m) computes all factorizations of n with no factor greater than m
	 * @param ret - the answer collection
	 * @param n - the number to factorize
	 * @param m - the maximum factor allowed
	 * @param path - the factorization so far
	 */
	static void dfs(List<List<Integer>> ret, int n, int m, List<Integer> path) {
		if (n == 1) {
			if (path.size() > 0) {
				List<Integer> ans = new ArrayList<Integer>(path);
				Collections.reverse(ans);
				ret.add(ans);
			}
			return;
		}
		if (m > n) {
			m = n;
		}
		for (int k = m; k > 1; k--) {
			if (n % k == 0) {
				path.add(k);
				dfs(ret, n / k, k, path);
				path.remove(path.size() - 1);
			}
		}
	}
	
	static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> ret = new ArrayList<>();
		dfs(ret, n, n / 2, new ArrayList<Integer>());
		return ret;
    }

	public static void main(String[] args) {
		System.out.println(getFactors(1));
		System.out.println(getFactors(37));
		System.out.println(getFactors(12));
		System.out.println(getFactors(32));
		System.out.println(getFactors(72));
	}
}
