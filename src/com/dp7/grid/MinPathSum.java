package com.dp7.grid;

public class MinPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//64. Minimum Path Sum
	private static int solve(int i,int j,int grid[][]){
		
        if(!isValid(i, j, grid))    return Integer.MAX_VALUE;
        
		if (i == 0 && j == 0) return grid[i][j];

        int left = solve(i,j-1,grid);
        int up = solve(i-1,j,grid);
        return grid[i][j] + Math.min(left,up);
    }
    private static int solveMem(int i,int j,int grid[][],int dp[][]){
    	
        if(!isValid(i, j, grid))    return Integer.MAX_VALUE;
		if (i == 0 && j == 0) return grid[i][j];
        
        if(dp[i][j] != -1)    return dp[i][j];
        
        int left = solveMem(i,j-1,grid,dp);
        int up = solveMem(i-1,j,grid,dp);
        return dp[i][j] = grid[i][j] + Math.min(left,up);
    }

    private static int solveTab(int m,int n,int grid[][]){
    	
        int dp[][] = new int[m+1][n+1];
        
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++){
				if (i == 0 && j == 0) dp[i][j] = grid[i][j];
				else if (i == 0) dp[i][j] = dp[i][j-1]+ grid[i][j];
				else if (j == 0) dp[i][j] = dp[i-1][j]+ grid[i][j]; 
            }
        }
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
			}
        }
        return dp[m][n];
    }
    private static boolean isValid(int i, int j, int grid[][]) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)	return false;
    	 else return true;
    			 
    }
}
