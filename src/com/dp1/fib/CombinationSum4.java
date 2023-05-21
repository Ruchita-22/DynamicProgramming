package com.dp1.fib;

import java.util.Arrays;

public class CombinationSum4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//377. Combination Sum IV
	private static int solve(int[] arr,int sum){
        if(sum<0)  return 0;
        if(sum==0) return 1;
        int ans = 0;
        for(int i=0;i<arr.length;i++)
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
