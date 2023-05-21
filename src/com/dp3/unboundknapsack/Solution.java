package com.dp3.unboundknapsack;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int driver(int w, int[] values, int[] weights) {
        int dp[][] = new int[values.length+1][w+1];
        for(int temp[] : dp)    Arrays.fill(temp,-1);
        return solveMem(values.length,w,weights,values,dp);
        //return solveTab(values.length,w,weights,values);
    }
	private static int solve(int n, int w, int[] weights,int[] values) {
		if(n==0||w==0)	return 0;
		
		if(weights[n-1]<=w)
			return Math.max(
					values[n-1] + solve(n, w-weights[n-1], weights, values),
					solve(n-1, w, weights, values));
		else 
			return solve(n-1, w, weights, values);
	
	}
	private static int solveMem(int n, int w, int[] weights,int[] values,int dp[][]) {
		if(n==0||w==0)	return dp[n][w]= 0;
		
		if(dp[n][w] != -1) return dp[n][w];
		
		if(weights[n-1]<=w)
			return dp[n][w] = Math.max(
					values[n-1] + solveMem(n, w-weights[n-1], weights, values,dp),
					solveMem(n-1, w, weights, values,dp));
		else 
			return dp[n][w] = solveMem(n-1, w, weights, values,dp);
	
	}
	private static int solveTab(int n, int w, int[] weights,int[] values){
        int dp[][] = new int[n+1][w+1];
      
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                if(i==0 || j==0)    dp[i][j] = 0;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(weights[i-1]<=j)
                    dp[i][j] = Math.max(values[i-1]+dp[i][j-weights[i-1]],dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];     
            }
        }
        return dp[n][w];
    }
	private static int solveSpaceOptimization(int n, int w, int[] weights,int[] values){
        
		int dp[] = new int[w+1];
        Arrays.fill(dp,0);

        for(int i=1;i<n+1;i++){
            // left to right
            for(int j=1;j<w+1;j++){
                if(weights[i-1]<=j)
                    dp[j] = Math.max(values[i-1]+dp[j-weights[i-1]],dp[j]);
                else
                    dp[j] = dp[j];     
            }
        }
        return dp[w];
    }


}
