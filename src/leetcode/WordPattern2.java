/**
 * @created Oct 15, 2015
 * @author franklsf95
 * 
 * @problem word-pattern-ii
 * @difficulty hard
 */

package leetcode;

import java.util.*;

public class WordPattern2 {
	
	static boolean search(String p, String s, int pAt, int sAt, HashMap<String, String> dict) {
		boolean pEnd = pAt == p.length();
		boolean sEnd = sAt == s.length();
		if (pEnd && sEnd) {
			return true;
		}
		if (pEnd ^ sEnd) {
			return false;
		}
		// Now p is not end and s is not end.
		String key = p.substring(pAt, pAt + 1);
		if (dict.containsKey(key)) {
			// try to match key.
			String val = dict.get(key);
			if (s.substring(sAt).startsWith(val)) {
				// match success, continue.
				return search(p, s, pAt + 1, sAt + val.length(), dict);
			} else {
				// match failure, return.
				return false;
			}
		}
		// For each possible matching, add it to dict, test it, and iterate.
		for (int sUntil = sAt + 1; sUntil <= s.length(); sUntil++) {
			String val = s.substring(sAt, sUntil);
			if (dict.containsValue(val)) {
				// Dict cannot contain duplicate values.
				continue;
			}
			dict.put(key, val);
			boolean result = search(p, s, pAt + 1, sUntil, dict);
			if (result) {
				System.err.println("Success! " + dict);
				return true;
			}
			// Else, if matching fails...
			dict.remove(key);
		}
		// If everything fails...
		return false;
	}
	
	static boolean wordPatternMatch(String pattern, String str) {
        return search(pattern, str, 0, 0, new HashMap<String, String>());
    }
	
	public static void main(String[] args) {
		String p, s;
		
		p = "abab";
		s = "redblueredblue";
		System.out.println(p + " + " + s + "\t= " + wordPatternMatch(p, s) + " == true?");

		p = "aaaa";
		s = "asdasdasdasd";
		System.out.println(p + " + " + s + "\t= " + wordPatternMatch(p, s) + " == true?");

		p = "aabb";
		s = "xyzabcxzyabc";
		System.out.println(p + " + " + s + "\t= " + wordPatternMatch(p, s) + " == false?");
		
		p = "aabb";
		s = "xyzxyzxyzxyz";
		System.out.println(p + " + " + s + "\t= " + wordPatternMatch(p, s) + " == false?");
	}

}
