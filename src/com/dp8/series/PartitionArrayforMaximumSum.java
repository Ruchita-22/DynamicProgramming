package com.dp8.series;

import java.util.Arrays;
//https://www.youtube.com/watch?v=PhWWJmaKfMc
public class PartitionArrayforMaximumSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int maxSumAfterPartitioning(int[] arr, int k) {
	        int n = arr.length;
	        int dp[] = new int[n+1];
	        Arrays.fill(dp,-1);
	        return solve(0,arr,k,dp);

	    }
	    private static int solve(int i, int arr[], int k, int dp[]){
	        int n = arr.length;

	        if(i== n )   return 0;
	        if(dp[i] != -1) return dp[i];

	        int len = 0, max = 0, ans = 0;
	        
	        for(int j=i;j< Math.min(i+k, n);j++){
	            len++;
	            max = Math.max(arr[j], max);
	            int sum = len*max + solve(j+1,arr,k,dp);
	            ans = Math.max(ans,sum);
	        }
	        return dp[i] = ans;
	    }

}
