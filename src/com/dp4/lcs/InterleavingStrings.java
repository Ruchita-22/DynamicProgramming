package com.dp4.lcs;

import java.util.Arrays;

public class InterleavingStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//97. Interleaving String
	public int isInterleave(String A, String B, String C) {
        int m = A.length();
        int n = B.length();
        
        if(C.length() != (m+n)) return 0;
        
        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp)   Arrays.fill(t,-1);
        
        return solve(0,0,0,A,B,C,dp)==true ? 1:0;

    }
    private static boolean solve(int i, int j, int k, String A, String B, String C, int dp[][]){
		
    	if (k == C.length())	return true;
        if(dp[i][j] != -1)    return dp[i][j] == 1 ? true : false;

        boolean ans = false;
		if (i < A.length() && A.charAt(i) == C.charAt(k))
			ans = ans || solve(i + 1, j, k + 1, A, B, C, dp);
		if (j < B.length() && B.charAt(j) == C.charAt(k))
			ans = ans || solve(i, j + 1, k + 1, A, B, C, dp);   
        
        dp[i][j] = ans==true ? 1 : 0;    
        return ans; 
    }


/*
We generally dont make boolean dp otherwise its difficult to find
false is its default value of came by calculation
*/
//i+j == k    always
    //712. Minimum ASCII Delete Sum for Two Strings
	public int minimumDeleteSum(String s1, String s2) {
	    int n = s1.length();
	    int m = s2.length();
	     int dp[][] = new int[n+1][m+1];
	    for(int t[] : dp)   Arrays.fill(t, -1);
	    return solve(n, m, s1, s2, dp);
	}
	
	
	private static int solve(int n, int m, String x, String y, int dp[][]){
	    if(n == 0 && m == 0)    return 0;
	    if(dp[n][m] != -1)  return dp[n][m];
	    
	    if(n == 0){
	        return dp[n][m] = y.charAt(m-1) + solve(n, m-1, x, y, dp);
	    }
	     if(m == 0){
	        return dp[n][m] = x.charAt(n-1) + solve(n-1, m, x, y, dp);
	    }
	   
	    if(x.charAt(n-1) == y.charAt(m-1))  
	        return dp[n][m] = solve(n-1, m-1, x, y, dp);
	    else 
	        return dp[n][m] = Math.min ( x.charAt(n-1) + solve(n-1, m, x, y, dp) , y.charAt(m-1) + solve(n, m-1, x, y, dp));
	   
	    
	}

}