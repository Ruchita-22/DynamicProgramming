package com.dp1.fib;

import java.util.Arrays;

public class HouseRobbery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//198. House Robber
	public int rob(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return solveMem(n, arr,dp);
    }

	private static int solveMem(int n, int arr[], int dp[]) {
		if (n < 1)		return 0;
		if (n == 1)		return arr[0];
		if (dp[n] != -1)	return dp[n];
		
		int inc = arr[n - 1] + solveMem(n - 2, arr, dp);
		int excl = solveMem(n - 1, arr, dp);
		return dp[n] = Math.max(inc, excl);
	}
    
    //213. House Robber II
    public int rob1(int[] arr) {
        int n = arr.length;
        if(n==1)    return arr[0];
        int arr1[] = new int[n-1];
        int arr2[] = new int[n-1];
        int j = 0, k = 0;
        for(int i=0;i<n;i++){
            if(i != n-1){
                arr1[j] = arr[i];
                j++;
            }     
            if(i != 0) {
                arr2[k] = arr[i];
                k++;
            }
        }
        return Math.max(rob(arr1),rob(arr2));

    }
    
    //1388. Pizza With 3n Slices
    public int maxSizeSlices(int[] arr) {
        int n = arr.length;

        int dp1[][] = new int[n+1][n+1];
        int dp2[][] = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j = 0;j<=n;j++){
                dp1[i][j] = -1;
                dp2[i][j] = -1;
            }
        }

        int case1 = solveMem(0, n/3, n-2, arr, dp1);
        int case2 = solveMem(1, n/3, n-1, arr, dp2);
        return Math.max(case1,case2);
    }
    //i = start
    private static int solveMem(int i, int k, int end, int arr[],int dp[][]){
        if(k == 0  || i > end) return 0;

        if(dp[i][k] != -1) return dp[i][k];
        int inc = arr[i] + solveMem(i+2,k-1,end,arr,dp);
        int excl = solveMem(i+1,k,end,arr,dp);
        return dp[i][k]  = Math.max(inc,excl);
    }
    
    
}
