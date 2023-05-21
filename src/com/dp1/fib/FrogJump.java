package com.dp1.fib;

public class FrogJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//1824. Minimum Sideway Jumps
	//https://leetcode.com/problems/minimum-sideway-jumps/
	public int minSideJumps(int[] obstacles) {
        return solve(2,0,obstacles);
    }
	private static int solve(int curr_lane, int pos, int obstacles[]){
        int n = obstacles.length-1;
        if(pos==n)  return 0;
        if(obstacles[pos+1] != curr_lane)   return solve(curr_lane, pos+1, obstacles);
        else{
            int ans = Integer.MAX_VALUE;
            for(int i=1;i<=3;i++){
                if(curr_lane != i && obstacles[pos] != i )
                    ans = Math.min(ans, 1 + solve(i,pos,obstacles));
            }
            return ans;
        }
    }
	private static int solveMem(int curr_lane, int pos, int obstacles[], int dp[][]){
        int n = obstacles.length-1;
        if(pos==n)  return 0;
        if(dp[pos][curr_lane] != -1)    return dp[pos][curr_lane];

        if(obstacles[pos+1] != curr_lane)   
            return dp[pos][curr_lane] = solveMem(curr_lane, pos+1, obstacles,dp);
        else{
            int ans = Integer.MAX_VALUE;
            for(int i=1;i<=3;i++){
                if(curr_lane != i && obstacles[pos] != i )
                    ans = Math.min(ans, 1 + solveMem(i,pos,obstacles,dp));
            }
            return dp[pos][curr_lane] = ans;
        }
    }

}
