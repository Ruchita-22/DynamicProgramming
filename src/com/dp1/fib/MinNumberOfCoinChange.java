package com.dp1.fib;

public class MinNumberOfCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static int solveMem(int n,int sum, int coins[]) {
	
		if(sum==0)	return 0;
		if(sum<0) return Integer.MAX_VALUE-1;
		
		int min = Integer.MAX_VALUE-1;
		for(int i=0;i<coins.length;i++) {
			int ans = 1 + solveMem(n,sum - coins[i],coins);
			if(ans!=Integer.MAX_VALUE-1)
				min = Math.min(min,ans);
		}
		return min;
	}
}
