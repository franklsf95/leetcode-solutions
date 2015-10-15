/**
 * @created Sep 16, 2015
 * @author franklsf95
 * 
 * @problem best-time-to-buy-and-sell-stock
 * @difficulty medium
 */
package leetcode;

public class BestTimeToBuyAndSellStock {
	
	static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
        	if (min > prices[i]) {
        		min = prices[i];
        	} else {
        		int profit = prices[i] - min;
        		if (maxProfit < profit) {
        			maxProfit = profit;
        		}
        	}
        }
        return maxProfit;
    }

	public static void main(String[] args) {
		int[] arr = {1, 5, 6, 4, 5, 7, 8};
		System.out.println(maxProfit(arr) + ", expected 7");
		int[] brr = {2, 1};
		System.out.println(maxProfit(brr) + ", expected 0");
	}

}
