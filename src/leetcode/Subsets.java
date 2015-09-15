/**
 * @created Sep 15, 2015
 * @author franklsf95
 * 
 * @problem subsets
 * @difficulty medium
 */

package leetcode;

import java.util.*;

public class Subsets {
	
	// ---- Bit Mask Solution
	
	static List<List<Integer>> subsets(int[] nums) {
        final int N = nums.length;
		long lim = 1 << N;
		List<List<Integer>> ret = new ArrayList<>();
		for (long mask = 0; mask < lim; mask++) {
			List<Integer> set = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				long bit = 1 << i;
				if ((bit & mask) != 0) {
					set.add(nums[i]);
				}
			}
			Collections.sort(set);
			ret.add(set);
		}
		return ret;
    }
	
	// ---- Recursive Solution
	
	static void subsetsRecursive(int[] nums, int index, List<Integer> sofar, List<List<Integer>> ret) {
		if (index >= nums.length) {
			Collections.sort(sofar);
			ret.add(sofar);
			return;
		}
		// Recurse without this element
		subsetsRecursive(nums, index + 1, sofar, ret);
		// Recurse with this element
		List<Integer> sofar2 = new ArrayList<Integer>(sofar);
		sofar2.add(nums[index]);
		subsetsRecursive(nums, index + 1, sofar2, ret);
    }
	
	public static void main(String[] args) {
		int arr[] = {4,1,0};
		List<List<Integer>> ret = new ArrayList<>();
		subsetsRecursive(arr, 0, new ArrayList<Integer>(), ret);
		System.out.println(ret);
	}
}
