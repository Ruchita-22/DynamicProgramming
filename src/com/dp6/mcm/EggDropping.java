package com.dp6.mcm;

import java.util.Arrays;

public class EggDropping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int e = 4;
		int f = 40;
		int dp[][] = new int[e+1][f+1];
        for(int t[] : dp)   Arrays.fill(t,-1);
        solveMem(e,f,dp);

	}
	
	//887. Super Egg Drop
	//https://leetcode.com/problems/super-egg-drop/
	
    private static int solve(int e, int f){
        if(f==0 || f==1)    return f;
        if(e==1)    return f;

        int ans = Integer.MAX_VALUE;
        for(int k=1;k<=f;k++){
            int temp = 1 + Math.max(solve(e-1,k-1), solve(e,f-k));
            ans = Math.min(ans, temp);
        }
        return ans;
    }
    
    private static int solveMem1(int e, int f, int dp[][]){
        if(f==0 || f==1)    return f;
        if(e==1)    return f;

        if(dp[e][f] != -1) return dp[e][f];

        int ans = Integer.MAX_VALUE;

        for(int k=1;k<=f;k++){
        	// egg break
            int case1;
            if(dp[e-1][k-1] != -1)   case1 = dp[e-1][k-1];
            else {
                dp[e-1][k-1] = solveMem1(e-1,k-1,dp);
                case1 = dp[e-1][k-1];
            }
            //egg not break
            int case2;
            if(dp[e][f-k] != -1) case2 = dp[e][f-k];
            else {
                dp[e][f-k] = solveMem1(e,f-k,dp);
                case2 = dp[e][f-k];
            }

            int temp = 1 + Math.max(case1,case2);
            ans = Math.min(ans, temp);
        }
        return dp[e][f] = ans;
    }
    // Binary search
    private static int solveMem(int e, int f, int dp[][]){
        if(f==0 || f==1)    return f;
        if(e==1)    return f;

        if(dp[e][f] != -1) return dp[e][f];

        int ans = Integer.MAX_VALUE;

        int i=0,j=f;
        while(i<j){
            int k = (i+j)/2;
            int case1 = solveMem(e-1,k-1,dp);
            int case2 = solveMem(e,f-k,dp);
            int temp = 1 + Math.max(case1,case2);
            ans = Math.min(ans, temp);
            if(case1==case2) break;
            else if(case1 < case2)  i = k+1;
            else j=k;

        }
        return dp[e][f] = ans;
    }
    //1884. Egg Drop With 2 Eggs and N Floors
  	//https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
    //take e=2 
  	
}
