package com.dp1.fib;

import java.util.Arrays;

public class MinimumNumberofSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int dp[];
    public int countMinSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    private static int solve(int n, int dp[]){
    	if(n == 0)    return 0;

        if(dp[n] != -1)   return dp[n];
        int ans = n;

		for (int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + solve(n - (i*i),dp));
        }
        return dp[n] = ans;
    }

}
