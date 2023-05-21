package com.dp2.knapsack;

public class SubsetSum1 {
	static int dp[][] = new int[100][1000];
	
	//Count the number of subset with the given sum
	private static int countOfSubsetSum(int[] arr, int sum) {
		// TODO Auto-generated method stub
		//base condition
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < sum+1; j++) {
				if(i==0)
					dp[i][j] = 0;
				if(j==0)
					dp[i][j] = 1;
			}
		}
		//choice diagram
		for (int i = 1; i < arr.length+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				if(arr[i-1] <= sum)
					dp[i][j] = dp[i-1][sum-arr[i-1]] + dp[i-1][sum];
				else 
					dp[i][j] = dp[i-1][sum];
			}
			
		}
		return dp[arr.length][sum];
	}
	private static int countOfSubsetDiff(int[] arr, int diff) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		int subSetSum = (diff+sum)/2;
		
		return countOfSubsetSum(arr, subSetSum);
	}
	
}
