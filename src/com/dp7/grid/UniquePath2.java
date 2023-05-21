package com.dp7.grid;

public class UniquePath2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static int solve(int i, int j,int grid[][]) {
		
		if(i<0 || j<0)	return 0;
		if(grid[i][j]==1)	return 0;
		if(i==0 && j==0)	return 1;
		
		int left = solve(i,j-1,grid);
		int up = solve(i-1,j,grid);
		
		return left+up;
	}
	private static int solveMem(int i, int j,int grid[][],int dp[][]) {
		if(i<0 || j<0)	return 0;
		if(grid[i][j]==1)	return 0;
        if(i==0 && j==0)	return 1;

		if(dp[i][j] != -1)    return dp[i][j];
		int left = solveMem(i,j-1,grid,dp);
		int up = solveMem(i-1,j,grid,dp);
		
		return dp[i][j] = left+up;
	}
	/////////////This is wrong
	private static int solveTab(int i, int j,int grid[][]) {
		int dp[][] = new int[i+1][j+1];
		for(int row=0;row<i+1;row++) {
			for(int col=0;col<j+1;col++) {
				
				if(row==0 || col==0) dp[row][col] = 1;
				if(grid[row][col]==1) dp[row][col] = 0;
			}
		}
		for(int row=1;row<i+1;row++) {
			for(int col=1;col<j+1;col++) {
				dp[row][col] = grid[row][col]==1 ? 0 : dp[row-1][col] + dp[row][col-1];
				
			}
		}
		return dp[i][j];
	}

}
