package com.dp3.unboundknapsack;

//Maximum number of ways
// 518. Coin Change II
public class CoinChange1 {


    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int t[] : dp)   Arrays.fill(t,-1);
        return solveMem(n, amount, coins,dp);
    }

    private static int solveMem(int n, int amt, int[] coins, int dp[][]){
        if(amt==0)  return 1;
        if(n==0 || amt<0)    return 0;

        if(dp[n][amt] != -1)    return dp[n][amt];

        if(coins[n-1]<=amt){
            int take =  solveMem(n,amt-coins[n-1],coins,dp);
            int notTake =  solveMem(n-1,amt,coins, dp);
            return dp[n][amt] = take + notTake;
        }
        else return dp[n][amt] = solveMem(n-1,amt,coins, dp);

    }
    private static int solveTab(int n, int amt, int[] coins){
        int dp[][] = new int[n+1][amt+1];

        for(int i=0;i<n+1;i++){
            for(int j = 0;j< amt+1;j++){
                if(j==0) dp[i][j] = 1;
                else if(i==0 || j<0) dp[i][j] = 0;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j = 1;j< amt+1;j++){
                if(coins[i-1]<=j){
                    int take =  dp[i][j-coins[i-1]];
                    int notTake =   dp[i-1][j];
                    dp[i][j] = take + notTake;
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amt];

    }
    private static int solveTab1(int n, int amt, int[] coins){
        int dp[] = new int[amt+1];
        dp[0]   = 1;

        for(int i=1;i<n+1;i++){
            for(int j = 0;j< amt+1;j++){
                if(coins[i-1]<=j){
                    int take =  dp[j-coins[i-1]];
                    int notTake =   dp[j];
                    dp[j] = take + notTake;
                }
                else dp[j] = dp[j];
            }
        }
        return dp[amt];

    }


}
