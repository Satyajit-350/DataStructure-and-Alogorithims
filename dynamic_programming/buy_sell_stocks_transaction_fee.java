package dynamic_programming;

import java.util.*;

public class buy_sell_stocks_transaction_fee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fee = sc.nextInt();
        int prices[] = new int[n];
        for(int i=0; i<n; i++){
            prices[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + maximumProfit(prices, n, fee));
    }
    public static int maximumProfit(int[] prices, int n, int fee) {
        // Write your code here.
        int dp[][] = new int[n+1][2];
        for(int i=0; i<=n; i++){
            for(int j=0; j<2; j++){
                dp[i][j] = -1;
            }
        }
        // return solve(0, 1, n, fee, prices);
        // return solveUsingMemoization(0, 1, n, fee, prices, dp);
        return solveUsingTabulation(1, n, fee, prices, dp);
    }
     //Recursive
    public static int solve(int idx,int buy, int n, int fee, int[] prices){
        //base case
        if(idx==n){
            return 0;
        }
        if(buy == 1){
            int take = (-prices[idx] + solve(idx+1, 0, n, fee, prices));
            int notTake = (0 + solve(idx+1, 1, n, fee, prices));
            return Math.max(take,notTake);
        }else{
            int take = (prices[idx] - fee + solve(idx+1, 1, n, fee, prices));
            int notTake = (0 + solve(idx+1, 0, n, fee, prices));
            return Math.max(take,notTake);
        }
    }
    //Memoization
    public static int solveUsingMemoization(int idx,int buy, int n, int fee, int[] prices, int dp[][]){
        //base case
        if(idx==n){
            return 0;
        }
        if(dp[idx][buy]!=-1){
            return dp[idx][buy];
        }
        if(buy == 1){
            int take = (-prices[idx] + solveUsingMemoization(idx+1, 0, n, fee, prices, dp));
            int notTake = (0 + solveUsingMemoization(idx+1, 1, n, fee, prices, dp));
            return dp[idx][buy] = Math.max(take,notTake);
        }else{
            int take = (prices[idx]- fee + solveUsingMemoization(idx+1, 1, n, fee, prices, dp));
            int notTake = (0 + solveUsingMemoization(idx+1, 0, n, fee, prices, dp));
            return dp[idx][buy] = Math.max(take,notTake);
        }
    }
    //Tabulation
    public static int solveUsingTabulation(int b, int n, int fee, int prices[],int dp[][]){
        dp[n][0] = 0;
        dp[n][1] = 0;
        for(int idx=n-1; idx>=0; idx--){
            for(int buy=0; buy<=1; buy++){
                if(buy == 1){
                    int take = (-prices[idx] + dp[idx+1][0]);
                    int notTake = (0 + dp[idx+1][1]);
                    dp[idx][buy] = Math.max(take,notTake);
                }else{
                    int take = (prices[idx] - fee + dp[idx+1][1]);
                    int notTake = (0 + dp[idx+1][0]);
                    dp[idx][buy] = Math.max(take,notTake);
                }
            }
        }
        return dp[0][1];
    }
}
