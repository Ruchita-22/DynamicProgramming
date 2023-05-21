package com.dp4.lcs;

import java.util.Arrays;

public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//115. Distinct Subsequences
	 public int numDistinct(String str, String ptr) {
	        int m = str.length();
	        int n = ptr.length();
	        int dp[][] = new int[m+1][n+1];
	        for(int t[] : dp)   Arrays.fill(t,-1);

	        return solve(m,n,str,ptr,dp);
	    }
	    private static int solve(int i, int j, String str, String ptr, int dp[][]){
	        if(j==0)    return 1;
	        if(i==0)    return 0;
	        if(dp[i][j] != -1)  return dp[i][j];

	        if(str.charAt(i-1)==ptr.charAt(j-1))
	            return dp[i][j] = solve(i-1,j-1,str,ptr,dp) + solve(i-1,j,str,ptr,dp);
	        else   
	            return dp[i][j] = solve(i-1,j,str,ptr,dp);  
	    }

}
