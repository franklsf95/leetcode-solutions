/**
 * @created Sep 15, 2015
 * @author franklsf95
 * 
 * @problem one-edit-distance
 * @difficulty medium
 */

package leetcode;

public class OneEditDistance {
	
	static boolean isOneEditDistance(String s, String t) {
		final int slen = s.length();
		final int tlen = t.length();
        if (slen == tlen) {
        	// Check for number of different letters
        	int d = 0;
        	for (int i = 0; i < slen; i++) {
        		if (s.charAt(i) != t.charAt(i)) {
        			d++;
        		}
        	}
        	return d == 1;  // 0 is false; 1 is true; 2+ is false
        }
        if (slen - tlen == -1) {
        	return isOneEditDistance(t, s);
        }
        if (slen - tlen != 1) {
        	return false;
        }
        // Now, s is one letter longer than t
        int pos = 0;
        for (pos = 0; pos < tlen; pos++) {
        	if (s.charAt(pos) != t.charAt(pos)) {
    			break;
    		}
        }
        // True if t is all contained in s
        if (pos == tlen) {
        	return true;
        }
        // Now, s and t are the same from 0 to pos
        // Check if they are the same from pos to tlen - 1
        for (int i = pos; i < tlen; i++) {
        	if (s.charAt(i + 1) != t.charAt(i)) {
    			return false;
    		}
        }
        return true;
    }

	public static void main(String[] args) {
		System.out.println(isOneEditDistance("hello", "hell") + " = true");
		System.out.println(isOneEditDistance("world", "world") + " = false");
		System.out.println(isOneEditDistance("affect", "effect") + " = true");
		System.out.println(isOneEditDistance("ab", "acb") + " = true");
	}
}
