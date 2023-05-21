package com.dp8.series;

import java.util.HashMap;

public class AirthmeticProgression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static int lengthOfLongestAP(int arr[]) {
		int n = arr.length;
		if(n <= 2)	return n;
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				int diff = arr[j] - arr[i];
				ans = Math.max(ans, 2+ solve(i, diff, arr));
			}
		}
		return ans;
	}
	private static int solve(int j, int diff, int[] arr) {
		if(j<0)	return 0;
		int ans=0;
		
		for(int i=j-1; i>=0; i--) {
			if(arr[j]-arr[i] == diff) {
				ans = Math.max(ans, 1 + solve(i, diff, arr));
			}
		}
		return ans;
	}

	public int longestArithSeqLength(int[] arr) {
		int n = arr.length;
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++)
			map.put(i, new HashMap<>());
		int max = 2;
		for (int e = 1; e < n; e++) {
			for (int s = 0; s < e; s++) {
				int diff = arr[e] - arr[s];
				map.get(e).put(diff, map.get(s).getOrDefault(diff, 1) + 1);
				max = Math.max(max, map.get(e).get(diff));
			}
		}
		return max;
	}

}
