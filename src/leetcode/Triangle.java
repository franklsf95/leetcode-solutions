/**
 * @created Sep 28, 2015
 * @author franklsf95
 * 
 * @problem triangle
 * @difficulty medium
 */
package leetcode;

import java.util.*;

public class Triangle {
	
	// f[i][j] denotes the minimum path to point (i, j)
	// f[i][j] = min(f[i-1][j-1], f[i-1][j]), except for edges
	static int minimumTotal(List<List<Integer>> triangle) {
		final int N = triangle.size();
		final int M = triangle.get(N - 1).size();
        int[][] f = new int[N][M];
        f[0][0] = triangle.get(0).get(0);
        
        for (int r = 1; r < N; r++) {
        	for (int c = 0; c <= r; c++) {
        		int a = Integer.MAX_VALUE;
        		int b = Integer.MAX_VALUE;
        		if (c < r) {
        			a = f[r - 1][c];
        		}
        		if (c > 0) {
        			b = f[r - 1][c - 1];
        		}
        		if (a > b) {
        			f[r][c] = b;
        		} else {
        			f[r][c] = a;
        		}
        		f[r][c] += triangle.get(r).get(c);
//        		System.err.printf("f[%d][%d] = %d\n", r, c, f[r][c]);
        	}
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
        	if (min > f[N-1][i]) {
        		min = f[N-1][i];
        	}
        }
        return min;
    }

	public static void main(String[] args) {
		List<List<Integer>> t = new ArrayList<>();
		ArrayList<Integer> t1 = new ArrayList<Integer>();
		t1.add(2);
		t.add(t1);
		ArrayList<Integer> t2 = new ArrayList<Integer>();
		t2.add(3);
		t2.add(4);
		t.add(t2);
		ArrayList<Integer> t3 = new ArrayList<Integer>();
		t3.add(6);
		t3.add(5);
		t3.add(7);
		t.add(t3);
		ArrayList<Integer> t4 = new ArrayList<Integer>();
		t4.add(4);
		t4.add(1);
		t4.add(8);
		t4.add(3);
		t.add(t4);
		System.out.println(minimumTotal(t));
	}

}
