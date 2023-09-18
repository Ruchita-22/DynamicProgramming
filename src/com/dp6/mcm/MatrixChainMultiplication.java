package com.dp6.mcm;

import java.util.Arrays;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {10,20,30,40,50};
//		ans = Integer.MAX_VALUE;
//		int ans =  solve(1, arr.length-1,arr);
		int n = arr.length;
		int dp[][] = new int[n+1][n+1];
		for(int t[] : dp)
			Arrays.fill(t, -1);
	}
	static int ans = Integer.MAX_VALUE;
	private static int solve(int i, int j,int arr[]) {
		
		if(i >= j)	return 0;
		
		for (int k = i; k < j; k++) {
			int temp = solve(i, k, arr) + solve(k + 1, j, arr) + arr[i - 1] * arr[k] * arr[j];
			ans = Math.min(ans, temp);
			
		}
		return ans;
		
	}
	
	
	private static int solveMem(int i, int j,int arr[],int dp[][]) {
		
		if(i >= j)	return 0;
		if(dp[i][j] != -1)	return dp[i][j];
		
		dp[i][j] = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = arr[i - 1] * arr[k] * arr[j] + solveMem(i, k, arr, dp) + solveMem(k + 1, j, arr, dp);
			dp[i][j] = Math.min(dp[i][j], temp);
			
		}
		return dp[i][j];
	}
	private static int solveTab(int arr[]) {
		int n = arr.length;
		int dp[][] = new int[n+1][n+1];
		for(int t[] : dp)
			Arrays.fill(t, Integer.MAX_VALUE);
		
		for(int i=1;i<arr.length;i++) {
			for (int j = 1; j < arr.length; j++) {
				if (i == j)	dp[i][j] = 0;
			}
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				for (int k = i; k < j; k++) {
					int temp = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
					dp[i][j] = Math.min(dp[i][j], temp);
				}
			}
		}
		return dp[n][n];
	}
}
