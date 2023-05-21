package com.dp8.series;

import java.util.Arrays;
import java.util.PriorityQueue;

public class StoneGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//1406. Stone Game III
	public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);

		int ans = solve(0, stoneValue,dp);

		if(ans>0)	return "Alice";
		else if(ans==0)	return "Tie";
		else return "Bob";
    }
	private static int solve(int i, int[] arr, int dp[]) {
		int n = arr.length;
		if(i >= n)	return 0;
        if(dp[i] != -1) return dp[i];

		int ans = Integer.MIN_VALUE;
		int case1 = arr[i] - solve(i+1, arr,dp);
		int case2 = i+1 < n ? arr[i]+arr[i+1] - solve(i+2, arr,dp) : Integer.MIN_VALUE;
		int case3 = i+2 < n ?  arr[i]+arr[i+1]+arr[i+2] - solve(i+3, arr,dp) : Integer.MIN_VALUE;
		ans = Math.max(case1, Math.max(case2, case3));
		return dp[i] = ans;
	}
	private static int solveTab(int[] arr) {
		int n = arr.length;
		int dp[] = new int[n+1];
		dp[n] = 0;
		int ans = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--) {
    		int case1 = arr[i] - dp[i+1];
    		int case2 = i+1 < n ? arr[i]+arr[i+1] - dp[i+2] : Integer.MIN_VALUE;
    		int case3 = i+2 < n ?  arr[i]+arr[i+1]+arr[i+2] - dp[i+3] : Integer.MIN_VALUE;
    		ans = Math.max(case1, Math.max(case2, case3));
    		dp[i] = ans;
        }
        return dp[0];
		
	}
	//1510. Stone Game IV
	public boolean winnerSquareGame(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp)==1;
    }
    private static int solve(int n, int dp[]) {
		if(n<=0)	return 0;
        if(dp[n] != -1) return dp[n];
		for(int i=1; i*i <= n; i++) {
			if(solve(n - i*i,dp)==0)	return dp[n] = 1;
		}
		return dp[n] = 0;
	}
    //1563. Stone Game V
    public int stoneGameV(int[] stoneValue) {
    	int n = stoneValue.length;
        int dp[][] = new int[n+1][n+1];
        for(int t[] : dp)   Arrays.fill(t,-1);
        return solve(0, n-1, stoneValue,dp);
    }
    private static int solve(int s, int e, int arr[], int dp[][]) {
    	if(s>e)	return 0;

    	if(dp[s][e] != -1)  return dp[s][e];

    	int sumR = 0;
    	for(int i=s;i<=e;i++)	sumR += arr[i];

    	int sumL=0;
    	int ans = 0;
    	for(int i=s;i<e;i++) {
    		sumL += arr[i];
    		sumR -= arr[i];
            
    		int case1 = sumL < sumR ? sumL + solve(s, i, arr,dp) : 0;
    		int case2 = sumL == sumR ? Math.max(sumL + solve(s, i,arr,dp), sumR+solve(i+1, e, arr,dp)) : 0;
    		int case3 = sumL > sumR ? sumR+solve(i+1, e, arr,dp) : 0;
    		ans = Math.max(ans,Math.max(case1, Math.max(case2, case3)));
    	}
    	return dp[s][e] = ans;
    	
    }
    //1686. Stone Game VI
    // Greedy approach
    static class Pair{
    	int x, y;
    	public Pair(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)-> o2.x - o1.x);
        int n = aliceValues.length;
        for(int i=0;i<n;i++) {
        	int v = aliceValues[i] + bobValues[i];
        	pq.add(new Pair(v, i));
        }
        
        int aliceSum = 0, bobSum = 0,turn = 0;
        while(pq.size()>0) {
        	Pair p = pq.poll();
        	if(turn==0)	{
        		aliceSum += aliceValues[p.y];
        		turn = 1;
        	}
        	else if(turn==1) {
        		bobSum += bobValues[p.y] ;
        		turn = 0;
        	}
        }
        return aliceSum > bobSum ? 1 : ( aliceSum==bobSum ? 0 : -1);
    }
    //1690. Stone Game VII
    public int stoneGameVII(int[] stones) {
    	int n = stones.length;
    	int pf[] = new int[n+1];
    	for(int i=0;i<n;i++) {
    		pf[i+1] = pf[i]+stones[i];
    	}
        
    	int dp[][] = new int[n+1][n+1];
        for(int t[] : dp)
            Arrays.fill(t,-1);
    	return solve(0,n-1,stones,pf,dp);   
    }
    private static int solve(int i, int j, int arr[], int pf[], int dp[][]) {
    	if(i>j) return 0;
        if(dp[i][j] != -1)  return dp[i][j];
    	int case1 = pf[j+1] - pf[i+1] - solve(i+1,j,arr,pf,dp);
    	int case2 = pf[j] - pf[i] - solve(i, j-1, arr, pf,dp);

        
    	return dp[i][j] = Math.max(case1, case2);
    }
    
}
