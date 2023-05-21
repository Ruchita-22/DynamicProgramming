package com.dp2.knapsack;

public class SubsetSumProblem {
	//https://leetcode.com/problems/partition-equal-subset-sum/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static boolean solve(int n, int sum, int arr[]) {
		if(sum==0)	return true;	
		if(n==0) return false;
		if(arr[n-1]<=sum) 
			return solve(n-1,sum-arr[n-1],arr) || solve(n-1,sum,arr);
		else 
			return solve(n-1,sum,arr);
	}
	private static boolean solveTab(int n, int sum, int arr[]) {
		boolean dp[][] = new boolean[n+1][sum+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0; j<sum+1;j++) {
				if(i==0 && j==0)	dp[i][j] = true;
				else if(j==0)	dp[i][j] = true;
				else if(i==0)   dp[i][j] = false;
					
			}
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1; j<sum+1;j++) {
				if(arr[i-1]<=j)	dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
				else dp[i][j] = dp[i-1][j];
			}
		}
		return dp[n][sum];
	}
	
}
