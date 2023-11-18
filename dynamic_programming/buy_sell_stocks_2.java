package dynamic_programming;

import java.util.*;

public class buy_sell_stocks_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long prices[] = new long[n];
        for(int i=0; i<n; i++){
            prices[i] = sc.nextLong();
        }
        System.out.println("Answer is: " + getMaximumProfit(n, prices));
    }
    public static long getMaximumProfit (int n, long[] values) {
        // Your code goes here. 
        long dp[][] = new long[n+1][2];
        for(int i=0; i<=n; i++){
            for(int j=0; j<2; j++){
                dp[i][j] = -1l;
            }
        }
        // return solve(0, 1, n, values);
        // return solveUsingMemoization(0, 1, n, values, dp);
        return solveUsingTabulation(1, n, values, dp);
    }
    //Recursive
    public static long solve(int idx,int buy, int n, long[] prices){
        //base case
        if(idx==n){
            return 0;
        }
        long profit = 0;
        if(buy == 1){
            long take = (-prices[idx] + solve(idx+1, 0, n, prices));
            long notTake = (0 + solve(idx+1, 1, n, prices));
            profit = Math.max(take,notTake);
        }else{
            long take = (prices[idx] + solve(idx+1, 1, n, prices));
            long notTake = (0 + solve(idx+1, 0, n, prices));
            profit = Math.max(take,notTake);
        }
        return profit;
    }
    //Memoization
    public static long solveUsingMemoization(int idx,int buy, int n, long[] prices, long dp[][]){
        //base case
        if(idx==n){
            return 0;
        }
        if(dp[idx][buy]!=-1){
            return dp[idx][buy];
        }
        long profit = 0;
        if(buy == 1){
            long take = (-prices[idx] + solveUsingMemoization(idx+1, 0, n, prices, dp));
            long notTake = (0 + solveUsingMemoization(idx+1, 1, n, prices, dp));
            profit = Math.max(take,notTake);
        }else{
            long take = (prices[idx] + solveUsingMemoization(idx+1, 1, n, prices, dp));
            long notTake = (0 + solveUsingMemoization(idx+1, 0, n, prices, dp));
            profit = Math.max(take,notTake);
        }
        return dp[idx][buy] = profit;
    }
    //Tabulation
    public static long solveUsingTabulation(int b, int n, long prices[],long dp[][]){
        dp[n][0] = 0;
        dp[n][1] = 0;
        for(int idx=n-1; idx>=0; idx--){
            for(int buy=0; buy<=1; buy++){
                long profit = 0;
                if(buy == 1){
                    long take = (-prices[idx] + dp[idx+1][0]);
                    long notTake = (0 + dp[idx+1][1]);
                    profit = Math.max(take,notTake);
                }else{
                    long take = (prices[idx] + dp[idx+1][1]);
                    long notTake = (0 + dp[idx+1][0]);
                    profit = Math.max(take,notTake);
                }
                dp[idx][buy] = profit;
            }
        }
        return dp[0][1];
    }
}
