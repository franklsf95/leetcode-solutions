/**
 * @created Sep 15, 2015
 * @author franklsf95
 * 
 * @problem letter-combinations-of-a-phone-number
 * @difficulty medium
 */

package leetcode;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
	
	static char[] lettersFromDigit(String d) {
		String s = "";
		if (d.equals("2")) {
			s = "abc";
		} else if (d.equals("3")) {
			s = "def";
		} else if (d.equals("4")) {
			s = "ghi";
		} else if (d.equals("5")) {
			s = "jkl";
		} else if (d.equals("6")) {
			s = "mno";
		} else if (d.equals("7")) {
			s = "pqrs";
		} else if (d.equals("8")) {
			s = "tuv";
		} else if (d.equals("9")) {
			s = "wxyz";
		}
		return s.toCharArray();
	}
	
	static void dfs(String digits, int index, StringBuilder acc, List<String> ret) {
		if (index == digits.length()) {
			if (acc.length() > 0) {
				ret.add(acc.toString());
			}
			return;
		}
		char[] letters = lettersFromDigit(digits.substring(index, index + 1));
		if (letters.length > 0) {
			for (char c: letters) {
				acc.append(c);
				dfs(digits, index + 1, acc, ret);
				acc.deleteCharAt(acc.length() - 1);
			}
		} else {
			dfs(digits, index + 1, acc, ret);
		}
	}
	
	static List<String> letterCombinations(String digits) {
		List<String> ret = new ArrayList<String>();
		dfs(digits, 0, new StringBuilder(), ret);
		return ret;
    }
	
	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}
}
