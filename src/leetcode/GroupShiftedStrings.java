/**
 * @created Oct 3, 2015
 * @author franklsf95
 * 
 * @problem group-shifted-strings
 * @difficulty easy
 */

package leetcode;

import java.util.*;

public class GroupShiftedStrings {
	
	// O(N)
	static boolean equivalent(String a, String b) {
		final int N = a.length();
		if (b.length() != N) {
			return false;
		}
		if (N == 0) {
			return true;
		}
		int diff = a.charAt(0) - b.charAt(0);
		if (diff < 0) {
			diff += 26;
		}
		for (int i = 1; i < N; i++) {
			int d = a.charAt(i) - b.charAt(i);
			if (d < 0) {
				d += 26;
			}
			if (d != diff) {
				return false;
			}
		}
		return true;
	}
	
	static List<List<String>> groupStrings(String[] strings) {
		List<List<String>> ret = new ArrayList<>();
        for (String s: strings) {
        	boolean added = false;
        	for (List<String> lst: ret) {
        		String t = lst.get(0);
        		if (equivalent(t, s)) {
        			lst.add(s);
        			added = true;
        			break;
        		}
        	}
        	if (!added) {
        		List<String> lst = new ArrayList<>();
        		lst.add(s);
        		ret.add(lst);
        	}
        }
        for (List<String> lst: ret) {
        	Collections.sort(lst);
        }        
		return ret;
    }

	public static void main(String[] args) {
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		System.out.println(groupStrings(strings));
	}
}
