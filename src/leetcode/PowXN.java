/**
 * @created Sep 16, 2015
 * @author franklsf95
 * 
 * @problem powx-n
 * @difficulty medium
 */
package leetcode;

public class PowXN {
	
	static double myPow(double x, int n) {
		System.err.printf("pow(%.0f, %d)\n", x, n);
        if (Math.abs(x - 1) < 0.000001) {
        	return 1;
        }
        if (Math.abs(x - (-1)) < 0.000001) {
        	if ((n & 1) == 0) {
        		// Even
        		return 1;
        	} else {
        		return -1;
        	}
        }
        if (n == 0) {
        	return 1;
        }
        if (n < 0) {
        	// WARNING: Cannot handle -2147483647
        	double inverse = myPow(x, -n);
        	return 1 / inverse;
        }
        // Find the highest bit of n
        int t = n;
        int exp = 0;
        while (t != 0) {
        	exp++;
        	t >>= 1;
        }
        exp--;
        System.err.printf("exp = %d\n", exp);
        // Do squaring for exp times
        double ans = x;
        for (int i = 0; i < exp; i++) {
        	ans *= ans;
        }
        // Do the rest power
        int r = n ^ (1 << exp);
        return ans * myPow(x, r);
    }

	public static void main(String[] args) {
		System.out.println(myPow(1, -2147483648));
		System.out.println(myPow(10, 0));
		System.out.println(myPow(10, 5));
		System.out.println(myPow(10, 10));
		System.out.println(myPow(2, 24));
		System.out.println(myPow(2, 32));
		System.out.println(myPow(2, -3));
	}

}
