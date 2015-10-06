/**
 * @created Sep 18, 2015
 * @author franklsf95
 * 
 * @problem kth-largest-element-in-an-array
 * @difficulty medium
 */
package leetcode;

import java.util.*;

public class KthLargestElementInAnArray {

	static int findKthLargest(int[] nums, int k) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        if (k <= 0 || k > arr.length) {
        	return 0;
        }
        return arr[arr.length - k];
    }

	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 9, 8, 7, 8, 2};
		System.out.println(findKthLargest(arr, 2) + " == 8");
		System.out.println(findKthLargest(arr, 3) + " == 7");
		System.out.println(findKthLargest(arr, 7) + " == 2");
	}

}
