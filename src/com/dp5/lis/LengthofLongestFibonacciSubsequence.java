package com.dp5.lis;

import java.util.Arrays;
import java.util.HashMap;

public class LengthofLongestFibonacciSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solve(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n+1][n+1];

        for(int t[] : dp)   Arrays.fill(t,2);

        HashMap<Integer, Integer> idx = new HashMap<>();
        for(int i=0;i<arr.length;i++)   idx.put(arr[i],i);
        
        int ans = 0;

        for(int k=2;k<arr.length;k++){
            for(int j=k-1;j>=1;j--){
                //arr[i]+arr[j] = arr[k];
                int key = arr[k]-arr[j];
                if(key>=arr[j])  continue;
                if(idx.containsKey(key)==false) continue;
                int i = idx.get(key);
                dp[j][k] = 1+dp[i][j];
                ans = Math.max(ans,dp[j][k]);
            }
        }
        return ans<3 ? 0 : ans;
    }
}
