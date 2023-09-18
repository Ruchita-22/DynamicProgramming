package com.dp4.lcs;

import java.util.Arrays;
//https://www.youtube.com/watch?v=8HEjwf28LyE&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=37
//https://leetcode.com/problems/edit-distance/description/

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// by insert, delete, update make s1 to s2 with min operation
	public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp)   Arrays.fill(t,-1);
        return solveMem(m,n,word1,word2,dp);
    }
    private static int solve(int i, int j, String word1, String word2){
    	
        if(i == 0)    return j;
        if(j == 0)    return i;
       
        if(word1.charAt(i-1) == word2.charAt(j-1))    return solve(i-1,j-1,word1,word2);
        else{
            int insert = 1 + solve(i,j-1,word1,word2);
            int delete = 1 + solve(i-1,j,word1,word2);
            int replace = 1 + solve(i-1,j-1,word1,word2);
            return  Math.min(insert, Math.min(delete,replace));
        }
    }
    private static int solveMem(int i, int j, String word1, String word2, int dp[][]){
    	
        if(i == 0)    return j;
        if(j == 0)    return i;
        
        if(dp[i][j] != -1)  return dp[i][j];
        
        if(word1.charAt(i-1) == word2.charAt(j-1))    return solveMem(i-1,j-1,word1,word2,dp);
        else{
            int insert = 1 + solveMem(i,j-1,word1,word2,dp);
            int delete = 1 + solveMem(i-1,j,word1,word2,dp);
            int replace = 1 + solveMem(i-1,j-1,word1,word2,dp);
            return  dp[i][j] = Math.min(insert, Math.min(delete,replace));
        }
    }
    private static int solveTab(String word1, String word2){
    	
    	int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp)   Arrays.fill(t,-1);
        
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0)		dp[i][j] = j;
				if (j == 0)		dp[i][j] = i;
			}
        }
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))    dp[i][j] =  dp[i-1][j-1];
                else{
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(insert, Math.min(delete,replace));
                }
        	}
        }
        return dp[m][n];
    }
    
    //583. Delete Operation for Two Strings
    public int minDistance1(String word1, String word2) {
	    int n = word1.length();
	    int m = word2.length();
	    int l =  solve1(n, m, word1, word2);
        return m + n - 2*l;
        
    }
    private static int solve1(int n, int m, String x, String y){
        int dp[][] = new int[n+1][m+1];
        for(int t[] : dp)   Arrays.fill(t,-1);
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0)  dp[i][j] = 0;
            }
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(x.charAt(i-1) == y.charAt(j-1))
                     dp[i][j]  = 1 + dp[i-1][j-1] ;
                else 
                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
        
    }
}
