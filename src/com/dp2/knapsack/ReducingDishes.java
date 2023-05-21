package com.dp2.knapsack;

import java.util.Arrays;

public class ReducingDishes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//1402. Reducing Dishes
    public int maxSatisfaction(int[] satisfaction) {
       Arrays.sort(satisfaction);
       int n = satisfaction.length;
       int dp[][] = new int[n+1][n+1];
       for(int t[] : dp)	Arrays.fill(t, -1);
       return solve(0,1,satisfaction,dp);
    }
    private static int solve(int i, int time, int arr[],int dp[][]) {
    	if(i==arr.length)	return 0;
    	if(dp[i][time] != -1)return dp[i][time];
    	
    	int inc = arr[i]*time + solve(i+1, time+1, arr,dp);
    	int exc = solve(i+1, time, arr,dp);
    	return dp[i][time] = Math.max(inc, exc);
    }
    // Tab is not working fine
    private static int solveTab(int arr[]) {
    	Arrays.sort(arr);
        int n = arr.length;
    	int dp[][] = new int[n+1][n+1];
    
 
    	for(int i=arr.length-1;i>=0 ;i--) {
    		for(int time=i;time>=0;time--) {
    			int inc = arr[i]*time + dp[i+1][time+1];
    	    	int exc = dp[i+1][time];
    	    	return dp[i][time] = Math.max(inc, exc);
    		}
    	}
    	return dp[0][0];
    	
    }


}
