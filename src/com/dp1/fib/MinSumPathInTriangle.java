package com.dp1.fib;

import java.util.Arrays;

public class MinSumPathInTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int minimumTotal(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
        int dp[][] = new int[n][m];
        for(int t[] : dp)   Arrays.fill(t,-1);
        return solveMem(0,0,arr,dp);
	}
    private static int solve(int i, int j, int[][] arr){
    	int n = arr.length;
        if(i==n-1) return arr[i][j];

        return arr[i][j] +  Math.min ( solve(i+1,j, arr) , solve(i+1,j+1,arr));

    }
    private static int solveMem(int i, int j, int[][] arr,int dp[][]){
    	int n = arr.length;
        if(i==n-1) return arr[i][j];
        if(dp[i][j] != -1)   return dp[i][j];

        return dp[i][j] = arr[i][j] +  Math.min ( solveMem(i+1,j, arr,dp) , solveMem(i+1,j+1,arr,dp));

    }

}
