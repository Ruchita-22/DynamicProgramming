package com.dp7.grid;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//1277. Count Square Submatrices with All Ones
	//https://www.youtube.com/watch?v=1ebzAGxnAgg
    public int countSquares(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int dp[][] = new int[n+1][m+1];
        int ans=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
                if(mat[i][j] == 1)
                    ans += solveMem(i,j,mat,dp);
            }
        }
        return ans;
    }
    private static int solve(int i, int j,int mat[][]){

        if(!isValid(i,j,mat))   return 0;

		int x = solve(i, j + 1, mat);
		int y = solve(i + 1, j, mat);
		int z = solve(i + 1, j + 1, mat);
        return 1 + Math.min(x,Math.min(y,z));
    }
    private static int solveMem(int i, int j,int mat[][], int dp[][]){

        if(!isValid(i,j,mat))   return 0;
        if(dp[i][j] != 0)   return dp[i][j];
		int x = solveMem(i, j + 1, mat, dp);
		int y = solveMem(i + 1, j, mat, dp);
		int z = solveMem(i + 1, j + 1, mat, dp);

        return dp[i][j] = 1 + Math.min(x,Math.min(y,z));
    }
    private static boolean isValid(int i, int j, int mat[][]){
        int n = mat.length;
        int m = mat[0].length;
		if (i < 0 || i >= n || j < 0 || j >= m || mat[i][j] == 0)  return false;
        else return true;
    }
    ////////////////////////////
    //221. Maximal Square
    //https://www.youtube.com/watch?v=BE_gwjrBPMs
    public int maximalSquare(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int dp[][] = new int[n+1][m+1];

       int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] == '1') {
					int ans = solveMem(i, j, mat, dp);
					res = Math.max(res, ans);
				}
            }
        }
        return res * res;
    }
    private static int solveMem(int i, int j,char mat[][], int dp[][]){

        if(!isValid(i,j,mat))   return 0;

        if(dp[i][j] != 0)   return dp[i][j];

		int x = solveMem(i, j + 1, mat, dp);
		int y = solveMem(i + 1, j, mat, dp);
		int z = solveMem(i + 1, j + 1, mat, dp);
		return dp[i][j] = 1 + Math.min(x, Math.min(y, z));
    }
    private static boolean isValid(int i, int j, char mat[][]){
        int n = mat.length;
        int m = mat[0].length;
		if (i < 0 || i >= n || j < 0 || j >= m || mat[i][j] == '0')  return false;
        else return true;
    }

}
