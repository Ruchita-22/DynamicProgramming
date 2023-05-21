package com.dp8.series;

import java.util.Arrays;

public class JumpGame {
	//https://www.youtube.com/watch?v=A-Mc_0WsoaM
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//55. Jump Game
	//https://leetcode.com/problems/jump-game/
	/*
	 * We can solve this by greedy approach O(n)
	 * DP approach is O(n^2)
	 * */
	public boolean canJump(int[] arr) {
        int n = arr.length;
        int last = n-1;
        for(int i=n-2;i>=0;i--) {
        	if(i+arr[i]>=last)
        		last = i;
        }
        return last==0 ? true : false;
    }
	//45. Jump Game II
	//https://leetcode.com/problems/jump-game-ii/description/
	public int jump(int[] arr) {
		int n = arr.length;
		if(n==1)	return 0;
		int ans=1, max_reach = arr[0] , curr_reach = arr[0];
		int i=1;
		while(max_reach <= n-1) {
			if(curr_reach < i+arr[i]) curr_reach = i+arr[i];
			if(i == max_reach) {
				max_reach = curr_reach;
				ans++;
			}
			i++;
		}
        return ans;
        
    }
	//1306. Jump Game III
	public boolean canReach(int[] arr, int start) {
		int n = arr.length;
		boolean dp[] = new boolean[n+1];
		Arrays.fill(dp, false);
		return solve(start,arr,dp);
    }
	private static boolean solve(int start,int arr[], boolean dp[]) {
		int  n = arr.length;
		if(start>=n || start < 0 || dp[start]==true)	return false;
		if(arr[start] == 0)	return true;
		dp[start] = true;
		return solve(start-arr[start], arr, dp) || solve(start+arr[start], arr, dp);
	}
	
}
