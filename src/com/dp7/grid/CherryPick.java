package com.dp7.grid;

import java.util.Arrays;

public class CherryPick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// TC -  O(n*m*m*9)
	
	public int recursion(int x, int y1, int y2, int n, int m, int[][] grid, int dp[][][]) {
		int dy[] = new int[] { -1, 0, 1 };
		
		if (x == n)		return 0;
		int ans = 0;
		if (y1 == y2)	ans = grid[x][y1];
		else		ans = grid[x][y1] + grid[x][y2];
		
		if (dp[x][y1][y2] != -1)		return dp[x][y1][y2];

		int smallAns = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int Y1 = y1 + dy[i];
				int Y2 = y2 + dy[j];
				if (Y1 >= 0 && Y2 >= 0 && Y1 < m && Y2 < m) {		//isValid
					int temp = recursion(x + 1, Y1, Y2, n, m, grid, dp);
					if (temp > smallAns)
						smallAns = temp;
				}
			}
		}
		return dp[x][y1][y2] = ans + smallAns;
	}

	public int cherryPickup(int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;
		int dp[][][] = new int[n][m][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				Arrays.fill(dp[i][j], -1);
		}

		return recursion(0, 0, m - 1, n, m, grid, dp);

	}

}
