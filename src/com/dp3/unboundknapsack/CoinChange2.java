package com.dp3.unboundknapsack;

import java.util.Arrays;

//Min no. of coins
public class CoinChange2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static int solveTab(int n,int sum, int coins[]) {
		int dp[][] = new int[n+1][sum+1];
		for(int temp[] : dp)	Arrays.fill(temp, Integer.MAX_VALUE-1);
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0 && j==0) dp[i][j] = Integer.MAX_VALUE-1;
				else if(j==0)	dp[i][j] = 0;
			}
		}
		
		for(int j=1;j<sum;j++) {
			if(j%coins[0]==0)	dp[1][j] = 	(j/coins[0]);
			else dp[1][j] = Integer.MAX_VALUE-1;
		}
		
		for(int i=2;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(coins[i-1]<=j) dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][sum];
	}
	//another approach with 1D dp
//	private static int solveRec(int n,int sum, int coins[]) {
//		
//		if(sum==0)	return 0;
//		if(sum<0) return Integer.MAX_VALUE-1;
//		
//		int min = Integer.MAX_VALUE-1;
//		for(int i=0;i<coins.length;i++) {
//			int ans = 1 + solveMem(n,sum - coins[i],coins);
//			if(ans!=Integer.MAX_VALUE-1)
//				min = Math.min(min,ans);
//		}
//		return min;
//	}

}
