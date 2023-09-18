package com.dp7.grid;

import java.util.Arrays;

public class MinimumFallingPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//https://www.youtube.com/watch?v=T0h30zOtCmM
	//931. Minimum Falling Path Sum
	public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int dp[][] = new int[n+1][m+1];
        for(int t[] : dp)
            Arrays.fill(t,-1);
        int ans = Integer.MAX_VALUE;
        
        for(int j=0;j<matrix[0].length;j++){
            ans = Math.min(ans,solve(0,j,matrix,dp));
        }
        return ans;
    }
    private static int solve(int i, int j, int mat[][], int[][] dp){
        if(i == mat.length)   return 0;
        if(j < 0 || j >= mat[0].length)   return Integer.MAX_VALUE;
        if(dp[i][j] != -1)  return dp[i][j];
        
        int x = solve(i+1,j-1,mat,dp);
        int y = solve(i+1,j,mat,dp);
        int z = solve(i+1,j+1,mat,dp);

        return dp[i][j] = mat[i][j] + Math.min(x,Math.min(y,z));
    }
    
    //1289. Minimum Falling Path Sum II
    public int minFallingPathSum1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(n==1 && m==1)    return matrix[0][0];
        int dp[][] = new int[n+1][m+1];
        for(int t[] : dp)
            Arrays.fill(t,-1);

        int ans = Integer.MAX_VALUE;
        for(int j=0;j<matrix[0].length;j++){
            ans = Math.min(ans,solve1(0,j,matrix,dp));
        }
        return ans;
    }
    private static int solve1(int i, int j, int mat[][], int[][] dp){
        if(i==mat.length)   return 0;
        if(dp[i][j] != -1)  return dp[i][j];

        int t = 100000;
        for(int k = 0;k<mat[0].length;k++){
            if(k!=j)
                t = Math.min(t,solve1(i+1,k,mat,dp));
        }
        return dp[i][j] = mat[i][j] + t;
    }

}
