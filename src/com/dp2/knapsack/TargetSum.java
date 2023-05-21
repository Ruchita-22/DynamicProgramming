package com.dp2.knapsack;

//https://leetcode.com/problems/target-sum/description/
public class TargetSum {

    public int findTargetSumWays(int[] arr, int diff) {
        int sum = 0;
        diff = Math.abs(diff);  // if diff is -ve given or either use (s-diff)/2
        for(int e : arr)    sum += e;
        // edge case
        if(sum < diff || (sum+diff)%2 == 1)  return 0;
        int s = (sum+diff)/2;
        return solve(arr.length, arr,s);
    }
    private static int solve(int n, int[] arr, int sum){
        int dp[][] = new int[n+1][sum+1];

        dp[0][0] = 1;
        for(int i=1;i<n+1;i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    int take = dp[i - 1][j - arr[i - 1]];
                    int notTake = dp[i - 1][j];
                    dp[i][j] = take + notTake;

                } else {
                    int notTake = dp[i - 1][j];
                    dp[i][j] = notTake;
                }
            }
        }
        return dp[n][sum];
    }
	static int t[][] = new int[21][1001];

    private static int findTargetSumWays(int[] a, int diff) {
    	System.out.println("findTargetSumWays");
        int sum = 0;
        for(int i = 0; i< a.length ; i++)
            sum += a[i];
        int W = (diff+sum)/2;
        return knapsack(a,W,a.length);

    }
    private static int knapsack (int[] a, int W, int n) {
        System.out.println("knapsack");
        //Base condition
        for(int i = 0; i< n+1 ; i++){
            for(int j = 0; j< W+1; j++){
                if( i == 0 )
                    t[i][j] = 0;
                if( j == 0 )
                    t[i][j] = 1;
            }
        }
        for(int i = 0; i < n+1 ; i++){
            for(int j = 0; j < W+1; j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
        //Choice diagram
        for(int i = 1; i< n+1 ; i++){
            for(int j = 1; j< W+1; j++){
               if(a[i-1] <= W)
                    t[i][j] = t[i-1][j-a[i-1]] + t[i-1][j];
                else
                   t[i][j] = t[i-1][j];
            }
        }
        for(int i = 0; i < n+1 ; i++){
            for(int j = 0; j < W+1; j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
        return t[n][W];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 1, 1, 1, 1};
		int diff = 3;
		System.out.println(findTargetSumWays(a,diff));
	}
}
