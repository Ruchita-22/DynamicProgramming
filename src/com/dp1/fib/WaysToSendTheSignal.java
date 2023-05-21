package com.dp1.fib;

public class WaysToSendTheSignal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static int solveTab(int n){
        int mod = (int)(1e9+7);
        long dp[][] = new long[2][n+1];
        
        dp[0][1] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[0][i] = (dp[0][i - 1] + dp[1][i - 1])%mod;
            dp[1][i] = dp[0][i - 1] % mod;
        }
        //ans
        long ans=0;
        ans=(dp[0][n] + dp[1][n])%mod;
        return (int)ans;
    }
	public long solve(int last,int n,long[][] dp){
        if(n==1&&last==0)return 1;
        if(n==1&&last==1)return 1;
        long mod = 1000000007;
        if(dp[last][n]!=-1)return dp[last][n];
        long ans=0;
        if(last==0){
            ans=solve(0,n-1,dp)+solve(1,n-1,dp);
        }
        else if(last==1){
            ans=solve(0,n-1,dp);
        }
        return dp[last][n]=ans%mod;
    }
    
    

}
