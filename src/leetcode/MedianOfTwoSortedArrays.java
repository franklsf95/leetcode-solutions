/**
 * @created Oct 6, 2015
 * @author franklsf95
 * 
 * @problem median-of-two-sorted-arrays
 * @difficulty hard
 */
////BUGGY
package leetcode;

import java.util.*;

public class MedianOfTwoSortedArrays {
	
	// Find the kth element in the merged array of arr + brr
	// O(log(m+n))
	static int kthElement(int[] arr, int aLeft, int aRight, int [] brr, int bLeft, int bRight, int k) {
		System.err.printf("aLeft = %d, aRight = %d, bLeft = %d, bRight = %d, k = %d\n", aLeft, aRight, bLeft, bRight, k);
		final int aLen = aRight - aLeft + 1;
		final int bLen = bRight - bLeft + 1;
		
		if (aLen == 0) {
			return brr[bLeft + k];
		}
		if (bLen == 0) {
			return arr[aLeft + k];
		}
		if (k == 0) {
			return arr[aLeft] < brr[bLeft] ? arr[aLeft] : brr[bLeft];
		}
		
		int aMid = k * aLen / (aLen + bLen);
		int bMid = (k - aMid - 1);
		int aMidIndex = aMid + aLeft;
		int bMidIndex = bMid + bLeft;
		System.err.printf("aMid = %d, bMid = %d, aMidIndex = %d, bMidIndex = %d\n", aMid, bMid, aMidIndex, bMidIndex);
		
		if (arr[aMidIndex] > brr[bMidIndex]) {
			// Drop right section of arr and left section of brr
			k -= bMid + 1;
			aRight = aMidIndex;
			bLeft = bMidIndex + 1;
		} else {
			// Drop left section of arr and right section of brr
			k -= aMid + 1;
			bRight = bMidIndex;
			aLeft = aMidIndex + 1;
		}
		return kthElement(arr, aLeft, aRight, brr, bLeft, bRight, k);
	}
	
	static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		final int total = nums1.length + nums2.length;
		int[] onlyArr = null;
		if (nums1.length == 0) {
			onlyArr = nums2;
		} else if (nums2.length == 0) {
			onlyArr = nums1;
		}
		if (onlyArr != null) {
			if (total % 2 == 1) {
	        	return onlyArr[(total - 1) / 2];
	        } else {
	        	int a = onlyArr[total / 2 - 1];
	        	int b = onlyArr[total / 2];
	        	return (double)(a + b) / 2.0;
	        }
		}
		
        if (total % 2 == 1) {
        	return kthElement(nums1, 0, nums1.length, nums2, 0, nums2.length, (total - 1) / 2);
        } else {
        	int a = kthElement(nums1, 0, nums1.length, nums2, 0, nums2.length, total / 2 - 1);
        	int b = kthElement(nums1, 0, nums1.length, nums2, 0, nums2.length, total / 2);
        	return (double)(a + b) / 2.0;
        }
    }

	public static void main(String[] args) {
//		int[] arr = {1, 2, 3, 8, 9};
//		int[] brr = {4, 5, 6, 7};
		int[] arr = {1};
		int[] brr = {1};
		System.out.println(findMedianSortedArrays(arr, brr) + " = 5?");
		int[] crr = {4, 5, 6};
		System.out.println(findMedianSortedArrays(arr, crr) + " = 4.5?");
	}
}
