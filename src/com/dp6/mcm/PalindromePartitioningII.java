package com.dp6.mcm;

import java.util.Arrays;

public class PalindromePartitioningII {

	public int minCut(String s) {

		int n = s.length();
		int dp[] = new int[n];
		Arrays.fill(dp, -1);

		int dp2[][] = new int[n][n];
		for (int t[] : dp2)
			Arrays.fill(t, -1);
		return solve(s, 0, dp, dp2);

	}

	public int solve(String s, int idx, int dp1[], int dp2[][]) {
		if (idx == s.length())		return 0;
		if (isPalindrome(s, idx, s.length() - 1, dp2) == 1)		return 0;
		if (dp1[idx] != -1)		return dp1[idx];
		int ans = s.length() - idx;
		for (int i = idx; i < s.length(); i++) {
			if (isPalindrome(s, idx, i, dp2) == 1) {
				int tempAns = 1 + solve(s, i + 1, dp1, dp2);
				ans = Math.min(tempAns, ans);
			}
		}
		return dp1[idx] = ans;
	}

	public int isPalindrome(String s, int i, int j, int dp[][]) {
		if (i >= j)		return 1;
		if (dp[i][j] != -1)		return dp[i][j];
		if (s.charAt(i) == s.charAt(j) && isPalindrome(s, i + 1, j - 1, dp) == 1)		dp[i][j] = 1;
		else	dp[i][j] = 0;
		return dp[i][j];

	}
}
