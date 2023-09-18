package com.dp7.grid;

//https://leetcode.com/problems/unique-paths/
public class UniquePath1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//62. Unique Paths
	private static int solve(int i, int j) {
		if (i == 0 && j == 0)		return 1;
		if (i < 0 || j < 0)			return 0;

		int left = solve(i, j - 1);
		int up = solve(i - 1, j);

		return left + up;
	}
	private static int solveMem(int i, int j,int dp[][]) {
		if (i == 0 && j == 0)		return 1;
		if (i < 0 || j < 0)			return 0;

		
		if(dp[i][j] != -1)	return dp[i][j];
		
		int left = solve(i, j - 1);
		int up = solve(i - 1, j);
		
		return dp[i][j] = left + up;
	}
	private static int solveTab(int i, int j) {
		int dp[][] = new int[i+1][j+1];
		for (int row = 0; row < i + 1; row++) {
			for (int col = 0; col < j + 1; col++) {
				if (row == 0 || col == 0) dp[row][col] = 1;
			}
		}
		for (int row = 1; row < i + 1; row++) {
			for (int col = 1; col < j + 1; col++) {
				dp[row][col] = dp[row-1][col] + dp[row][col-1];
			}
		}
		return dp[i][j];
	}

}
