package com.dp3.unboundknapsack;

import java.util.Arrays;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solve(int[] prices) {
        int n = prices.length;
        return solveTab(n,n,prices);
    }
    private static int solveTab(int n, int l,int[] prices){
        int dp[][] = new int[n+1][l+1];
        for(int temp[]:dp)  Arrays.fill(temp,-1);

        for(int i=0;i<n+1;i++){
            for(int j=0;j<l+1;j++){
                if(i==0 || j==0)    dp[i][j] = 0;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<l+1;j++){
                if(i<=j){
                    dp[i][j] = Math.max(prices[i-1]+dp[i][j-i],dp[i-1][j]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][l];
    }

}
