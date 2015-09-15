/**
 * @created Sep 15, 2015
 * @author franklsf95
 * 
 * @problem word-break
 * @difficulty medium
 */

package leetcode;

import java.util.*;

public class WordBreak {
	
	// Dynamic Programming.
	// Let f[i] denote if the substring [1:i] can be segmented by dictionary
	// Now,
	// f[0] = true   [1:0] is just for convenience of the definition
	// f[i] = true   if for 0 <= j < i, f[j] = true AND [j+1:i] is a word
	//               Note that [j+1:i] is array index [j, i-1], or substring(j, i)
	//      = false  otherwise
	// For example, if f[5] = true because f[3] = true, that means
	// [4:5], or array index s[3:4], is a word.
	static boolean wordBreak(String s, Set<String> wordDict) {
        final int N = s.length();
        boolean[] f = new boolean[N + 1];
        f[0] = true;
        for (int i = 1; i <= N; i++) {
        	for (int j = 0; j < i; j++) {
        		// Find a suitable j
        		if (!f[j]) {
        			continue;
        		}
        		// Now f[j] is true
        		String sub = s.substring(j, i);
        		if (wordDict.contains(sub)) {
        			f[i] = true;
        			break;
        		}
        	}
        	System.err.println("f["+i+"] = "+f[i]);
        }        
		return f[N];
    }
	
	public static void main(String[] args) {
		String a = "abcde";
		System.out.println(a.substring(2, 3));
		
		String s = "leetcodehelloworldworld";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("cool");
		dict.add("code");
		dict.add("hell");
		dict.add("hello");
		dict.add("world");
		dict.add("wore");
		String t = "cooleet";
		System.out.println(wordBreak(s, dict));
		System.out.println(wordBreak(t, dict));
	}

}
