package com.dp1.fib;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciNumber {

	public static int[] dp;
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fib(n));

        
    }
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int a = fib(n-1);
        int b = fib(n-2);
        dp[n] = a + b;
        return dp[n];
    }
}
