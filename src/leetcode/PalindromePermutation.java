/**
 * @created Oct 3, 2015
 * @author franklsf95
 * 
 * @problem palindrome-permutation
 * @difficulty easy
 */

package leetcode;

public class PalindromePermutation {
	
	static boolean canPermutePalindrome(String s) {
		// Count of letter occurrences
        int count[] = new int[256];
        for (char c: s.toCharArray()) {
        	count[c] += 1;
        }
        int numOfOdds = 0;
        for (int c: count) {
        	if (c % 2 == 0) {
        		continue;
        	} else {
        		numOfOdds++;
        	}
        }
        return numOfOdds <= 1;
	}

	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("code") + " = false");
		System.out.println(canPermutePalindrome("aab") + " = true");
		System.out.println(canPermutePalindrome("carerac") + " = true");
		System.out.println(canPermutePalindrome("acrerac") + " = true");
		System.out.println(canPermutePalindrome("AaBb//a") + " = false");
	}
}
