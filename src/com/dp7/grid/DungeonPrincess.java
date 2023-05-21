package com.dp7.grid;

import java.util.Arrays;

public class DungeonPrincess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int calculateMinimumHP(int[][] mat) {
        // int m = mat.length;
        // int n = mat[0].length;
        // int dp[][] = new int[m+1][n+1];
        // for(int t[] : dp)   Arrays.fill(t,-1);

        // return solveMem(0,0,mat,dp);
        return solveTab(mat);
    }
    private static int solve(int i, int j, int mat[][]){
    	
    	if(!isValid(i, j, mat))     return Integer.MAX_VALUE;
        if(i==mat.length-1 && j==mat[0].length-1)   return  Math.max(1-mat[i][j],1);
        
        int ans = Math.min( solve(i+1,j,mat) , solve(i,j+1,mat) ) - mat[i][j];
        return ans<0 ? 1 : ans;
    }
     private static int solveMem(int i, int j, int mat[][],int dp[][]){
    	 
        if(!isValid(i, j, mat))    return Integer.MAX_VALUE;
        if(i==mat.length-1 && j==mat[0].length-1)   return  Math.max(1-mat[i][j],1);

        if(dp[i][j] != -1)    return dp[i][j];
        
        int ans = Math.min( solveMem(i+1,j,mat,dp) , solveMem(i,j+1,mat,dp) ) - mat[i][j];
        return dp[i][j] = (ans<=0 ? 1 : ans);
    }
    private static int solveTab(int mat[][]){
        int m = mat.length;
        int n = mat[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp)   Arrays.fill(t,-1);
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1)    dp[i][j] =  Math.max(1-mat[i][j],1);
                else if(i==m-1)         dp[i][j] =  Math.max(dp[i][j+1]-mat[i][j],1);
                else if(j==n-1)         dp[i][j] =  Math.max(dp[i+1][j]-mat[i][j],1);
            }
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j] = Math.max( 1, Math.min( dp[i+1][j] , dp[i][j+1] )-mat[i][j] );
            }
        }    
        return dp[0][0];
    }
    private static boolean isValid(int i, int j, int mat[][]) {
     if(i<0|| i>=mat.length || j<0 || j>=mat[0].length) 	return false;
   	 else return true;
   			 
   }
}
