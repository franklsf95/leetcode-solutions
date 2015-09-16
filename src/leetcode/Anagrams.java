/**
 * @created Sep 16, 2015
 * @author franklsf95
 * 
 * @problem anagrams
 * @difficulty medium
 */
package leetcode;

import java.util.*;

public class Anagrams {
	
	static List<List<String>> groupAnagrams(String[] strs) {
		final int N = strs.length;
		HashMap<Long, ArrayList<String>> hashMap = new HashMap<Long, ArrayList<String>>();
		ArrayList<Long> orderedHashes = new ArrayList<Long>();
        for (int i = 0; i < N; i++) {
        	String s = strs[i];
        	// Calculate hash
        	long hash = 0;
        	char[] charArray = s.toCharArray();
        	Arrays.sort(charArray);
        	long pow = 1;
    		for (char c: charArray) {
    			hash += (c - 'a' + 1) * pow;
    			pow *= 27;
    		}
        	// Insert into array
        	ArrayList<String> arrayList = hashMap.get(hash);
        	if (arrayList == null) {
        		arrayList = new ArrayList<String>();
        		arrayList.add(s);
        		hashMap.put(hash, arrayList);
        		orderedHashes.add(hash);
        	} else {
        		arrayList.add(s);
        	}
        }
        List<List<String>> ret = new ArrayList<>();
        for (long hash: orderedHashes) {
        	List<String> arrayList = hashMap.get(hash);
        	Collections.sort(arrayList);
        	ret.add(arrayList);
        }        
        return ret;
    }

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs));
	}

}
