/**
 * @created Sep 7, 2015
 * @author franklsf95
 * 
 * @problem search-in-rotated-sorted-array
 * @difficulty hard
 */

package leetcode;

import java.util.*;

public class SearchInRotatedSortedArray {
	
	// Reference: http://fisherlei.blogspot.com/2013/01/leetcode-search-in-rotated-sorted-array.html
	static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
    		System.err.println("Searching from [" + lo + "] to [" + hi + "]");
        	int mid = (lo + hi) / 2;
    		System.err.println("Mid index is [" + mid + "]");
        	if (nums[mid] == target) {
        		return mid;
        	}
        	if (nums[lo] <= nums[mid]) {
        		System.err.println("\tLeft part is sorted");
        		if (nums[lo] <= target && target <= nums[mid]) {
            		System.err.println("\t\ttarget is in left part, search left part");
        			hi = mid - 1;
        		} else {
            		System.err.println("\t\ttarget is in right part, search right part");
        			lo = mid + 1;
        		}
        	} else {
        		System.err.println("\tRight part is sorted");
        		if (nums[mid] <= target && target <= nums[hi]) {
            		System.err.println("\t\ttarget is in right part, search right part");
        			lo = mid + 1;
        		} else {
            		System.err.println("\t\ttarget is in left part, search left part");
        			hi = mid - 1;
        		}
        	}
        }
        return -1;
    }

	public static void main(String[] args) {
		int[] arr = {5,1,3};
		System.out.println(search(arr, 3));
	}
	
	static int bsearch(int[] a, int x) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int y = a[mid];
			if (x == y) {
				return mid;
			} else if (x < y) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}

}
