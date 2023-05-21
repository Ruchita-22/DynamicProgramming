package com.dp1.fib;

import java.util.Arrays;

public class WaysToDecode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int numDecodings(String str) {
        int dp[] = new int[str.length()+1];
        Arrays.fill(dp,-1);
        ans=0;
        return solveMem(0,str,dp);
        
    }
    static int ans;
    private static int solve(int pos, String s){
        if(pos >= s.length())   return 1 ;
        int op1 = s.charAt(pos)-'0';
        int op2=0;
        if(pos<s.length()-1)
            op2=op1*10+ s.charAt(pos+1)-'0';
        if(op1>0)   ans += solve(pos+1,s);
        if(op1>0 && op2>0 && op2<=26)    ans += solve(pos+2,s);  
        return ans;
    }
    private static int solveMem(int pos, String s, int dp[]){
        if(pos >= s.length())   return 1 ;
        if(dp[pos]!=-1) return dp[pos];
        int op1 = s.charAt(pos)-'0';
        int op2=0;
        if(pos<s.length()-1)
            op2=op1*10+ s.charAt(pos+1)-'0';
        if(op1>0)   ans = add(ans,solveMem(pos+1,s,dp));
        if(op1>0 && op2>0 && op2<=26)    ans = add(ans,solveMem(pos+2,s,dp)); 
        return dp[pos] = ans;
    }
    private static int add(int a, int b){
        int mod = (int)(1e9+7);
        return (int)(((a%mod)*1L+(b%mod))%mod);
    }

}
