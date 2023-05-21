package com.dp8.series;

import java.util.Arrays;

public class Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 122. Best Time to Buy and Sell Stock II
	public int maxProfit2(int[] prices) {
		int dp[][] = new int[prices.length + 1][2];
		for (int t[] : dp) {
			Arrays.fill(t, -1);
		}
		return solve(0, 1, prices, dp);

	}

	private static int solve(int i, int buy, int prices[], int dp[][]) {
		if (i == prices.length)	return 0;
		if (dp[i][buy] != -1)	return dp[i][buy];
		
		int profit = 0;
		if (buy == 1) {
			int buyKaro = -prices[i] + solve(i + 1, 0, prices, dp);
			int skipKaro = solve(i + 1, 1, prices, dp);
			profit = Math.max(buyKaro, skipKaro);
		} else {
			int sellKaro = prices[i] + solve(i + 1, 1, prices, dp);
			int skipKaro = solve(i + 1, 0, prices, dp);
			profit = Math.max(sellKaro, skipKaro);
		}
		return dp[i][buy] = profit;
	}

	// 714. Best Time to Buy and Sell Stock with Transaction Fee
	public int maxProfit(int[] prices, int fee) {
		int dp[][] = new int[prices.length + 1][2];
		for (int t[] : dp) {
			Arrays.fill(t, -1);
		}
		return solve2(0, 1, prices, fee, dp);

	}

	private static int solve2(int i, int buy, int prices[], int fee, int dp[][]) {
		if (i == prices.length)
			return 0;
		if (dp[i][buy] != -1)
			return dp[i][buy];
		int profit = 0;
		if (buy == 1) {
			int buyKaro = -prices[i] + solve2(i + 1, 0, prices, fee, dp);
			int skipKaro = solve2(i + 1, 1, prices, fee, dp);
			profit = Math.max(buyKaro, skipKaro);
		} else {
			int sellKaro = prices[i] - fee + solve2(i + 1, 1, prices, fee, dp);
			int skipKaro = solve2(i + 1, 0, prices, fee, dp);
			profit = Math.max(sellKaro, skipKaro);
		}
		return dp[i][buy] = profit;
	}

	// 123. Best Time to Buy and Sell Stock III
	// 188. Best Time to Buy and Sell Stock IV //same 2 replace by k
	public int maxProfit3(int[] prices) {
		int dp[][][] = new int[prices.length + 1][3][2];
		for (int t[][] : dp) {
			for (int t1[] : t)
				Arrays.fill(t1, -1);
		}
		return solve3(0, 2, 1, prices, dp);
	}

	private static int solve3(int i, int limit, int buy, int prices[], int dp[][][]) {
		if (i == prices.length || limit == 0)
			return 0;
		if (dp[i][limit][buy] != -1)
			return dp[i][limit][buy];
		int profit = 0;
		if (buy == 1) {
			int buyKaro = -prices[i] + solve3(i + 1, limit, 0, prices, dp);
			int skipKaro = solve3(i + 1, limit, 1, prices, dp);
			profit = Math.max(buyKaro, skipKaro);
		} else {
			int sellKaro = prices[i] + solve3(i + 1, limit - 1, 1, prices, dp);
			int skipKaro = solve3(i + 1, limit, 0, prices, dp);
			profit = Math.max(sellKaro, skipKaro);
		}
		return dp[i][limit][buy] = profit;
	}

}
