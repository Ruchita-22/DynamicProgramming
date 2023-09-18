package com.dp6.mcm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromicPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "nitin";
		int n = s.length();
		int dp[][] = new int[n+1][n+1];
		for(int t[] : dp)
			Arrays.fill(t, -1);
		
		solveMem(0, n-1, s, dp);
		

	}
	//131. Palindrome Partitioning
	static List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
		solveMem(0, s, new ArrayList<>());
        return res;  
    }

    private static void solveMem(int i,String s, List<String> temp) {
		int n = s.length();
		if(i == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
		for (int k = i; k < n; k++) {
			if (isPalindrome(i, k, s)) {
				temp.add(s.substring(i, k + 1));
				solveMem(k + 1, s, temp);
				temp.remove(temp.size() - 1);
			}
        }
	}
    
	private static int solveMem(int i, int j, String str,int dp[][]) {
		
		if(i >= j)	return 0;
		
		if(isPalindrome(i, j, str))	return 0;
		
		if(dp[i][j] != -1)	return dp[i][j];
		
		dp[i][j] = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = 1 + solveMem(i, k, str, dp) + solveMem(k + 1, j, str, dp);
			dp[i][j] = Math.min(dp[i][j], temp);
			
		}
		return dp[i][j];
	}
	private static boolean isPalindrome(int i, int j, String str) {
		if(i == j)	return true;
		while(i < j) {
			if(str.charAt(i) != str.charAt(j))	return false;
			i++; 
			j--;
		}
		return true;
		
	}

}
