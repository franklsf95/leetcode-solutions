/**
 * @created Sep 16, 2015
 * @author franklsf95
 * 
 * @problem anagrams
 * @difficulty medium
 */
package leetcode;

import java.util.*;

public class ProductOfArrayExceptSelf {
	
	// f[i] = a[0] * a[1] * ... * a[i]
	// g[i] = a[i] * a[i+1] * ... * a[n-1]
	static int[] productExceptSelf(int[] nums) {
		final int N = nums.length;
        int[] ret = new int[N];
		if (N == 0) {
			return ret;
		} else if (N == 1) {
			ret[0] = nums[0];
			return ret;
		}
        int[] f = new int[N];
        int[] g = new int[N];
        for (int i = 0; i < N; i++) {
        	if (i == 0) {
        		f[0] = nums[0];
        		g[N - 1] = nums[N - 1];
        	} else {
            	f[i] = f[i - 1] * nums[i];
            	g[N - i - 1] = g[N - i] * nums[N - i - 1];
        	}
        }
        for (int i = 0; i < N; i++) {
        	if (i == 0) {
        		ret[i] = g[i + 1];
        	} else if (i == N - 1) {
        		ret[i] = f[i - 1];
        	} else {
        		ret[i] = f[i - 1] * g[i + 1];
        	}
        }
        return ret;
    }

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		int[] ret = productExceptSelf(arr);
		for (int x: ret) {
			System.out.println(x);
		}
	}

}
