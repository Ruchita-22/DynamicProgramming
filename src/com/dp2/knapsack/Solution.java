package com.dp2.knapsack;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solve(int[] values, int[] weights, int w) {
        int n = values.length;
        int dp[][] = new int[n+1][w+1];
        for(int temp[] : dp){
            Arrays.fill(temp,-1);
        }
        return solveMem(n,w,values,weights,dp);
     
       
   }
	private static int solve(int n,int w, int[] values, int[] weights){
		
       if(n == 0 || w == 0)    return 0;
       
       
       if(weights[n-1] <= w){
           int take = values[n-1] + solve(n-1,w-weights[n-1],values,weights);
           int notTake = solve(n-1,w,values,weights);
           
           return Math.max(take,notTake);
       } 
       else {
	        int notTake = solve(n-1,w,values,weights);
	        return notTake;
       }
   }
	/*
       update fn name and add dp as parameter
       and update fn calling also
       add if(dp[n][w] != -1)    return dp[n][w];
       before returning update dp

    */
	private static int solveMem(int n,int w, int[] values, int[] weights, int[][] dp){
		
       if(n == 0 || w == 0)    return 0;
       if(dp[n][w] != -1)    return dp[n][w];
       
       if(weights[n-1] <= w){
           int take = values[n-1] + solveMem(n-1,w-weights[n-1],values,weights,dp);
           int notTake = solveMem(n-1,w,values,weights,dp);
           
           return dp[n][w] = Math.max(take,notTake);
       } 
       else {
	        int notTake = solveMem(n-1,w,values,weights,dp);
	        return dp[n][w] = notTake;
       }
   }

   /*
   	update fn name and remove dp as parameter
   	update base condition with loop
   	copy code and paste in loop
   	update n with i and w with j
   	remove fn call with dp[][]
   	remove return from loop and put it in end


    */
	private static int solveTab(int n,int w, int[] values, int[] weights){
		int dp[][] = new int[n+1][w+1];
		
		//Base condition
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<w+1;j++) {
				if(i==0 || j==0) 
					dp[i][j] = 0;
			}
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<w+1;j++) {
				if(weights[i-1] <= j){
		            int take = values[i-1] + dp[i-1][j-weights[i-1]];
		            int notTake = dp[i-1][j];
		            
		             dp[i][j] = Math.max(take,notTake);
		        } 
		        else {
			        int notTake = dp[i-1][j];
			        dp[i][j] = notTake;
		        }
			}
		}
       return dp[n][w];
   }
	private static int solveSpaceOptimize(int n,int w, int[] values, int[] weights){
		int prev[] = new int[w+1];
		int next[] = new int[w+1];
		Arrays.fill(prev,-1);
		Arrays.fill(next,0);
		

		for(int i=1;i<n+1;i++) {
			prev = next;
			next = new int[w+1];
			for(int j=1;j<w+1;j++) {
				if(weights[i-1] <= j){
		            int take = values[i-1] + prev[j-weights[i-1]];
		            int notTake = prev[j];
		            
		            next[j] = Math.max(take,notTake);
		        } 
		        else {
			        int notTake = prev[j];
			        next[j] = notTake;
		        }
			}
			
		}
       return next[w];
   }
	private static int solveSpaceOptimize1D( int n, int w,int values[], int weights[])
   {
       int []dp = new int[w+1];
       Arrays.fill(dp, 0);
       for(int i=0; i < n; i++) {
		   // right to left
           for(int j = w; j >= weights[i]; j--) {
               if(j>=weights[i])
                   dp[j] = Math.max(dp[j] , values[i] + dp[j - weights[i]]);
           }
       }    
       
       return dp[w];
   }

}
