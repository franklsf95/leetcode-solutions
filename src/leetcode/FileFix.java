package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileFix {

	static class Dir {
		String name;
		HashMap<String, Dir> dirs;
		
		Dir(String n) {
			name = n;
			dirs = new HashMap<String, FileFix.Dir>();
		}
		
		void print(String prefix) {
			String nPrefix = prefix + "/" + name;
			System.out.println(nPrefix);
			if (nPrefix.equals("/")) {
				nPrefix = "";
			}
			for (String d : dirs.keySet()) {
				dirs.get(d).print(nPrefix);
			}
		}
	}
	
	static int N, M;
	static Dir root;
	
	static void init() {
		root = new Dir("");
	}
	
	static int addPath(String path) {
		String[] components = path.split("/");
		// components[0] is root, so empty
		Dir pwd = root;
		int cnt = 0;
		for (int i = 1; i < components.length; i++) {
			String component = components[i];
			if (pwd.dirs.containsKey(component)) {
				pwd = pwd.dirs.get(component);
			} else {
				Dir ndir = new Dir(component);
				pwd.dirs.put(component, ndir);
				pwd = ndir;
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int j = 1; j <= T; j++) {
			N = in.nextInt();
			M = in.nextInt();
			init();
			for (int i = 0; i < N; i++) {
				String s = in.next();
				addPath(s);
			}
//			root.print("");
			// paths needed to be created
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				String s = in.next();
				cnt += addPath(s);
			}
			System.out.printf("Case #%d: %d\n", j, cnt);
		}

	}

}
