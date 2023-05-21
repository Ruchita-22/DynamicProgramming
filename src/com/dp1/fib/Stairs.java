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
        if(dp[n]!=-1)   return dp[n];
        dp[n] = solve(n-1)+solve(n-2);
        dp[n] = dp[n]%1000000007;
        return dp[n];
    }

}
