package com.dp5.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RussionDoll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Pair{
	    int width;
	    int height;
	    Pair(int width, int height){
	        this.width = width;
	        this.height = height;
	    }
	}
	public int solve(int[][] envelopes) {
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0;i<envelopes.length; i++){
            list.add(new Pair(envelopes[i][0],envelopes[i][1]));
        }
        // sort in inc order of width and dec order of height
        Collections.sort(list, (o1,o2)-> o1.width != o2.width ? o1.width - o2.width : o2.height - o1.height);
       // System.out.println(list);
       int n = list.size();
		
		int dp[] = new int[n+1];
		Arrays.fill(dp, 1);
		
		int ans=1;
		for(int k=1;k<n;k++) {
			for(int j = k-1;j>=0;j--) {
				if(list.get(j).height < list.get(k).height && dp[k]<dp[j]+1) {
					dp[k] = dp[j]+1;
				}
                ans = Math.max(dp[k], ans);	
			}
		}
		
		return ans;	
    }
}
