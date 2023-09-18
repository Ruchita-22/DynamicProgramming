package com.dp1.fib;

import java.util.Arrays;

public class Stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static long dp[];
    public int climbStairs(int n) {
        dp = new long[n+1];
        Arrays.fill(dp,-1);
        return (int)solve(n);
    }
    private static long solve(int n){
        if(n<3)    return n;
        if(dp[n] != -1)   return dp[n];
        dp[n] = solve(n-1)+solve(n-2);
        dp[n] = dp[n]%1000000007;
        return dp[n];
    }
    
   private static int waysToClimb(int n, int i) {
	   if(i == n)	return 1;
	   if(i > n)	return 0;
	   return waysToClimb(n, i+1) + waysToClimb(n, i+2);
   }
   
   private static int minCostToClimb(int cost[], int n) {
	   if(n == 0)	return cost[0];
	   if(n == 1)	return cost[1];
	   if(dp[n] != -1)	return (int) dp[n];
	   
	   return (int) (dp[n] = cost[n] + Math.min( minCostToClimb(cost, n-1), minCostToClimb(cost, n-2) )) ;
   }
   
   private static int minCostToClimbTab(int cost[], int n) {
	   int dp[] = new int[cost.length+1];
	   Arrays.fill(dp, -1);
	   dp[0] = cost[0];
	   dp[1] = cost[1];
	   
	   for (int i = 2; i < cost.length; i++) {
		     dp[n] = cost[n] + Math.min( dp[i-1], dp[i-2] ) ;
	   }
	   
	   return Math.min(dp[n-1], dp[n-2]);
   }
   

}
