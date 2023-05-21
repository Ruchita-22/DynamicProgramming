package com.dp5.lis;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static int solve(int arr[]) {
		int n = arr.length;
		
		int dp[] = new int[n+1];
		Arrays.fill(dp, 1);
		
		int ans=1;
		for(int k=1;k<arr.length;k++) {
			for(int j = k-1;j>=0;j--) {
				if(arr[j]<arr[k] && dp[k]<dp[j]+1) {
					dp[k] = dp[j]+1;
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
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]<tt[0])    tt[0] = arr[i];		//if element smaller than 0th position
            else if(arr[i]> tt[pos-1]){				// if element greater than last pos so put on curr pos
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
        while(l<=r){
            int m = (l+r)/2;
            if(arr[m]<x)    l=m+1;
            else{
                index = m;
                r=m-1;
            }
        }
        return index;
    }

}
