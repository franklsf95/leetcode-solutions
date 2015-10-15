package leetcode;

import java.util.*;

public class MinimumScalarProduct {
	
	static int L;
	static HashSet<String> dict;
	static HashSet<String> pool;
	
	static void buildPool() {
		pool = new HashSet<String>(L * dict.size());
		pool.add("");
		for (String s: dict) {
			for (int i = 1; i < s.length(); i++) {
				pool.add(s.substring(0, i));
			}
		}
//		for (String p: pool) {
//			System.out.println(p);
//		}
//		System.out.println("----");
	}
	
	static int solve(String pattern) {
		return inDict(new StringBuilder(L), pattern, 0);
	}
	
	static int inDict(StringBuilder sofar, String pattern, int pos) {
		if (sofar.length() == L) {
			if (dict.contains(sofar.toString())) {
//				System.out.println(sofar);
				return 1;
			}
		}
		if (pos >= pattern.length()) {
			return 0;
		}
		if (!pool.contains(sofar.toString())) {
//			System.out.println(sofar + " No hope");
			return 0;
		}
		char c = pattern.charAt(pos);
		ArrayList<Character> cs = new ArrayList<Character>();
		pos++;
		if (c == '(') {
			while (pos < pattern.length()) {
				c = pattern.charAt(pos);
				if (c == ')') {
					pos++;
					break;
				}
				cs.add(c);
				pos++;
			}
		} else if (c != ')') {  // c should not be ')' anyhow
			cs.add(c);
		}
		// pos is the position of next char
		int tot = 0;
		for (char t: cs) {
			sofar.append(t);
			tot += inDict(sofar, pattern, pos);
			sofar.deleteCharAt(sofar.length() - 1);  // the last char
		}
		return tot;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		L = in.nextInt();
		int D = in.nextInt();
		int nCases = in.nextInt();
		dict = new HashSet<String>(D);
		for (int i = 0; i < D; i++) {
			dict.add(in.next());
		}
		buildPool();
		for (int i = 1; i <= nCases; i++) {
			String pattern = in.next();
			System.out.printf("Case #%d: %d\n", i, solve(pattern));
		}
		in.close();
	}
}
