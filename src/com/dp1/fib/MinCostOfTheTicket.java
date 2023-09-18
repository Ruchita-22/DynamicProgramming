package com.dp1.fib;

import java.util.Arrays;

public class MinCostOfTheTicket {
	
	public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        
        return solve(0,n, days, costs, dp);
    }
    private  static int solve(int pos, int n, int[] days, int[] costs, int[] dp ){
        if(pos >= n)    return 0;
        if(dp[pos] != -1)   return dp[pos];
        int op1 = costs[0] + solve(pos+1, n, days, costs, dp);
        
        for(int i = pos; i<n && days[i] < days[pos] + 7 ; i++);
        int op2 = costs[1] + solve(i , n, days, costs, dp);
        
        for(int i = pos; i<n && days[i] < days[pos] + 30 ; i++);
        int op3 = costs[2] + solve(i , n, days, costs, dp);
        
        return dp[pos] = Math.min(op1, Math.min(op2, op3));
        
    }
}
