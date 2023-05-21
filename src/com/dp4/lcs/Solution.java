package com.dp4.lcs;

import java.util.Arrays;

public class Solution {

	static int t[][] = new int[1001][1001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String X = "abcdefh";
		String Y = "abedfhr";
		
		System.out.println(longestCommonSubsequence(X,Y));

	}
	private static int lcs(String X, String Y, int m, int n,int t[][]) {
		//Base Condition
		if( m == 0 || n == 0 )
			return 0;
		//memorization
		if(t[m][n] != -1)
			return t[m][n];
		//choice diagram
		if(X.charAt(m-1)==Y.charAt(n-1))
			return t[m][n] = 1+lcs(X,Y,m-1,n-1,t);
		else {
			return t[m][n] = Math.max( lcs(X,Y,m-1,n,t), lcs(X,Y,m,n-1,t));
		}
	}

	public static int longestCommonSubsequence(String X, String Y) {
		int m = X.length();
		int n = Y.length();
		int t[][] = new int[m+1][n+1];
		for (int[] temp : t) {
			Arrays.fill(temp, -1);
		}
		return lcs(X,Y, m, n, t);
		 
    }
	public static int shortestCommonSupersequence(String X, String Y) {
		int m = X.length();
		int n = Y.length();
		int t[][] = new int[m+1][n+1];
		for (int[] temp : t) {
			Arrays.fill(temp, -1);
		}
		return m+n - lcs(X,Y, m, n, t);
		 
    }
	public static int minInsertions(String s) {
		if(s==null||s.length()==0 || isPalindrome(s))
			return 0;
		else {
			String rev = reverse(s);
			
			int n = s.length();
			int t[][] = new int[n+1][n+1];
			for (int[] temp : t) {
				Arrays.fill(temp, -1);
			}
			
			return n - lcs(s,rev,n,n,t);
		}
			
    }
	public static int longestPalindromeSubseq(String s) {
        
        //base condition
		if(s==null)
			return 0;
        if(isPalindrome(s))
            return s.length();
        
        //reverse string
        String s1 = reverse(s);
		
		int n = s.length();
		int t[][] = new int[n+1][n+1];
		for (int[] temp : t) {
			Arrays.fill(temp, -1);
		}
		
		return lcs(s,s1,n,n,t);
    }
	
	////////////////////////Helper////////////////////////
	public static String reverse(String s) {
		String temp = "";
		for (int i = s.length()-1; i >=0; i--) {
			temp += s.charAt(i);
		}
		return temp;
	}
	public static boolean isPalindrome(String s) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = s.length()-1;
		while(i<j) {
			if(s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			}
			else
				return false;
		}
		return true;
	}

	
}
