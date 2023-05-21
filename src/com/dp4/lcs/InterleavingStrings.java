package com.dp4.lcs;

import java.util.Arrays;

public class InterleavingStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int isInterleave(String A, String B, String C) {
        int m = A.length();
        int n = B.length();
        if(C.length() != (m+n)) return 0;
        
        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp)   Arrays.fill(t,-1);
        
        return solve(0,0,0,A,B,C,dp)==true ? 1:0;

    }
    private static boolean solve(int i, int j, int k, String A, String B, String C, int dp[][]){
        if(k==C.length())   return true;
        
        if(dp[i][j]!=-1)    return dp[i][j]==1 ? true : false;

        boolean ans = false;
        if(i<A.length() && A.charAt(i)==C.charAt(k))
            ans = ans ||  solve(i+1,j,k+1,A,B,C,dp);
        if(j<B.length() && B.charAt(j)==C.charAt(k))
            ans = ans || solve(i,j+1,k+1,A,B,C,dp);   
        
        dp[i][j] = ans==true ? 1 : 0;    
        return ans; 
    }

}
/*
We generally dont make boolean dp otherwise its difficult to find
false is its default value of came by calculation
*/
//i+j == k    always
