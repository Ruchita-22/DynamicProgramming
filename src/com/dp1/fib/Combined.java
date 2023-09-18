package com.dp1.fib;

import java.util.Arrays;

public class Combined {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// Min coin to make sum
	private static int solveMem(int n,int sum, int coins[]) {
	
		if(sum == 0)	return 0;
		if(sum < 0) return Integer.MAX_VALUE-1;
		
		int min = Integer.MAX_VALUE-1;
		
		for(int i=0;i<coins.length;i++) {
			
			int ans = 1 + solveMem(n, sum - coins[i],coins);
			if(ans != Integer.MAX_VALUE-1)
				min = Math.min(min,ans);
		}
		return min;
	}
	// Min no of perfect squrare
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
	//377. Combination Sum IV
	private static int solve(int[] arr,int sum){
        if(sum < 0)  return 0;
        if(sum == 0) return 1;
        int ans = 0;
        
		for (int i = 0; i < arr.length; i++)
            ans += solve(arr,sum-arr[i]);
        return ans;   
    }
	private static int solveTab(int[] arr,int sum){
        int dp[] = new int[sum+1];
        Arrays.fill(dp,0);
        dp[0] = 1;
        for(int i=1;i<sum+1;i++){
            for(int j = 0;j<arr.length;j++){
                if(i-arr[j] >= 0)
                    dp[i] += dp[i-arr[j]];
            }
        }
        return dp[sum]; 
    }
	
	

}
