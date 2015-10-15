/**
 * @created Sep 7, 2015
 * @author franklsf95
 * 
 * @problem h-index, h-index-ii
 * @difficulty medium
 */

package leetcode;

public class H_Index {
	
	static boolean check(int[] citations, int h) {
		int N = citations.length;
		boolean flag = true;
		if (N - h < N) {
			flag &= citations[N - h] >= h;
		}
		if (N - h - 1 >= 0) {
			flag &= citations[N - h - 1] <= h;
		}
		return flag;
	}
	
	static int hIndex(int[] citations) {
		int N = citations.length;
//		Arrays.sort(citations);
		for (int h = N; h >= 0; h--) {
			if (check(citations, h)) {
				return h;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] a = {0, 1, 3, 5, 6};
		System.out.println(hIndex(a));
	}

}
