package leetcode;

import java.util.*;

public class AllYourBase {
	
	static String digits = "1023456789abcdefghijklmnopqrstuvwxyz";
	
	static long solve(String s) {
		int L = s.length();
		int next = 0;
		if (L <= 1) {
			// a single letter could always mean 1 (not 0)
			return 1;
		}
		boolean[] converted = new boolean[L];
		char[] result = new char[L];
		for (int i = 0; i < L; i++) {
			// s[i] <=> digits[next]
			if (!converted[i]) {
				char d = s.charAt(i);
				char c = digits.charAt(next);
				for (int j = i; j < L; j++) {
					if (s.charAt(j) == d) {
						result[j] = c;
						converted[j] = true;
					}
				}
				next++;
			}
		}
		String p = new String(result);
//		System.out.println('"' + p + '"' + " @ " + next);
		if (next == 1) {
			next++;  // "111111" is only valid in base 2
		}
		// next is the number of distinct chars, i.e., the radix
		long ret = Long.parseLong(p, next);
		return ret;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int j = 1; j <= T; j++) {
			String cipher = in.next();
			System.out.printf("Case #%d: %d\n", j, solve(cipher));
		}
	}

}
