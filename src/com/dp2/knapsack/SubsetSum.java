package com.dp2.knapsack;

public class SubsetSum {

	//subset with given sum is present or not
	private static boolean subsetSum(int n, int[] arr, int sum) {
		// TODO Auto-generated method stub
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
	//subset with equal subset is present or not
	private static boolean equalSumSubset(int[] arr) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		if(sum%2 != 0)
			return false;
		else 
			return subsetSum(arr.length, arr, sum/2);
			
	}
	//subset with s1-s2 = difference is present or not
	/*
	 * s1-s2 = min
	 * s1+s2 = range = sum of all elements
	 * add both the equation
	 * 2s1 = min+range
	 * s1 = (min+range)/2
	 * */
	private static boolean subsetDiff(int[] arr, int diff) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int e : arr)	sum += e;

		int subSetSum = (diff+sum)/2;
		
		return subsetSum(arr.length, arr, subSetSum);
	}
	
	
}
