package com.dp5.lis;

import java.util.Arrays;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// It is passes on leetcode but not on coding ninja
	// Stiver approach
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
		int dp[][] = new int[n+1][n+1];
        for(int t[] : dp)   Arrays.fill(t, -1);
		return solve1(0, -1, arr, dp) ;	
    }
    //memmization 
	private static int solve1(int i, int prev_i, int arr[], int dp[][]) {
		if(i == arr.length)	return 0;
		if(dp[i][prev_i+1] != -1)	return dp[i][prev_i+1];
		
		int len = 0 + solve1(i+1, prev_i, arr, dp);			// dont take
		if(prev_i == -1 || arr[i] > arr[prev_i]) {
			len = Math.max(len, 1 + solve1(i+1, i, arr, dp));		// take
		}
		return dp[i][prev_i+1] = len;
	}
	private static int solveTab1(int arr[]) {
		int n = arr.length;
		int dp[][] = new int[n+1][n+1];
        for(int t[] : dp)   Arrays.fill(t, 0);
        for (int i = n-1; i >= 0 ; i--) {
			for(int prev_i = i-1; prev_i >= -1; prev_i--) {
				int len = 0 + dp[i+1][prev_i];
				
				if(prev_i == -1 || arr[i] > arr[prev_i]) {
					len = Math.max(len, 1 + dp[i+1][i]);
				}
				dp[i][prev_i+1] = len;
			}
		}
		
		
		
		return dp[0][-1+1];
	}
	//// space optimization 
	private static int solveTab2(int arr[]) {
		int n = arr.length;
		int curr[] = new int[n+1];
		int next[] = new int[n+1];
		
         Arrays.fill(curr, 0);
         Arrays.fill(next, 0);
         
        for (int i = n-1; i >= 0 ; i--) {
			for(int prev_i = i-1; prev_i >= -1; prev_i--) {
				int len = 0 + next[prev_i];
				
				if(prev_i == -1 || arr[i] > arr[prev_i]) {
					len = Math.max(len, 1 + next[i]);
				}
				curr[prev_i+1] = len;
			}
			next = curr;
		}
		
		return next[-1+1];
	}
	
	//////////////////////another way but this give tle//////////////////
	// approaches given by love babbar
	private static int solve(int arr[]) {
		int n = arr.length;
		
		int dp[] = new int[n+1];
		Arrays.fill(dp, 1);
		
		int ans=1;
		for(int k=1;k<arr.length;k++) {
			for(int j = k-1;j>=0;j--) {
				if(arr[j] < arr[k] && dp[k] < 1 + dp[j]) {
					dp[k] = 1 + dp[j];
				}
                ans = Math.max(dp[k], ans);	
			}
		}
		
		return ans;	
	}
	//////////////////to avoid TLE//////////////////////
	private static boolean solve1(int arr[]){
        int n = arr.length;
        if(n == 0)    return false;
        int tt[] = new int[n];
        tt[0] = arr[0];
        int pos = 1;
        
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < tt[0])    tt[0] = arr[i];		//if element smaller than 0th position
            else if(arr[i] > tt[pos-1]){				// if element greater than last pos so put on curr pos
                tt[pos] = arr[i];					// to put element at first or last
                pos++;
                
            }
            else{
                int index =  lowerBound(0,pos-1,arr[i],tt);		// find correct postion of e and put it
                tt[index] = arr[i];
            }
        }
        return pos>2 ? true : false;

    }
    private static int lowerBound(int l,int r, int x, int arr[]){
        int index = -1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (arr[m] < x)
				l = m + 1;
			else {
				index = m;
				r = m - 1;
			}
        }
        return index;
    }

}
