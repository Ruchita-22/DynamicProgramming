package com.dp7.grid;

import java.util.ArrayList;
import java.util.Arrays;

public class MinPathSumInTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int minimumTotal(ArrayList<ArrayList<Integer>> arr) {
        int dp[][] = new int[arr.size()][arr.get(arr.size()-1).size()];
        for(int t[] : dp)   Arrays.fill(t,-1);
        return solveMem(0,0,arr,dp);
	}
    private static int solve(int i, int j, ArrayList<ArrayList<Integer>> arr){
        if(i==arr.size()-1) return arr.get(i).get(j);

        return arr.get(i).get(j) +  Math.min ( solve(i+1,j, arr) , solve(i+1,j+1,arr));

    }
    private static int solveMem(int i, int j, ArrayList<ArrayList<Integer>> arr,int dp[][]){
        if(i==arr.size()-1) return arr.get(i).get(j);
        if(dp[i][j] != -1)   return dp[i][j];

        return dp[i][j] = arr.get(i).get(j) +  Math.min ( solveMem(i+1,j, arr,dp) , solveMem(i+1,j+1,arr,dp));

    }

}
