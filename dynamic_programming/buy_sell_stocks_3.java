package dynamic_programming;

import java.util.*;

public class buy_sell_stocks_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prices[] = new int[n];
        for(int i=0; i<n; i++){
            prices[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + maxProfit(prices));
    }
    public static int maxProfit(int prices[]) {
        // Write your code here.
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];
        for(int i=0; i<=n; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        // return solve(0,1,2,n,prices);
        // return solveUsingMemoization(0,1,2,n,prices, dp);
        return solveUsingTabulation(n, prices, dp);
    }
    public static int solve(int idx, int buy, int cap, int n, int prices[]){
        //base cases
        if(cap==0) return 0;
        if(idx==n) return 0;
        if(buy==1){
            int take = ((-prices[idx]) + solve(idx+1, 0, cap, n, prices));
            int notTake = (0 + solve(idx+1, 1, cap, n, prices));
            return (int)Math.max(take, notTake);
        }else{
            int take = (prices[idx] + solve(idx+1, 1, cap-1, n, prices));
            int notTake = (0 + solve(idx+1, 0, cap, n, prices));
            return (int)Math.max(take, notTake);
        }
    }
    //Memoization
    public static int solveUsingMemoization(int idx, int buy, int cap, int n, int prices[], int dp[][][]){
        //base cases
        if(cap==0) return 0;
        if(idx==n) return 0;
        if(dp[idx][buy][cap] != -1){
            return dp[idx][buy][cap];
        }
        if(buy==1){
            int take = ((-prices[idx]) + solveUsingMemoization(idx+1, 0, cap, n, prices,dp));
            int notTake = (0 + solveUsingMemoization(idx+1, 1, cap, n, prices,dp));
            return dp[idx][buy][cap] = Math.max(take, notTake);
        }else{
            int take = (prices[idx] + solveUsingMemoization(idx+1, 1, cap-1, n, prices,dp));
            int notTake = (0 + solveUsingMemoization(idx+1, 0, cap, n, prices,dp));
            return dp[idx][buy][cap] = Math.max(take, notTake);
        }
    }
    //Tabulation
    public static int solveUsingTabulation(int n, int prices[], int dp[][][]){
        //base cases 
        //case 1: cap = 0, idx & buy can be anything
        for(int idx=0; idx<n; idx++){
            for(int buy=0; buy<=1; buy++){
                dp[idx][buy][0] = 0;
            }
        }
        //case 2: idx=0, buy & cap can be anything
        for(int buy=0; buy<=1; buy++){
            for(int cap=0; cap<=2; cap++){
                dp[n][buy][cap] = 0;
            }
        }
        for(int idx=n-1; idx>=0; idx--){
            for(int buy=0; buy<=1; buy++){
                for(int cap=1; cap<=2; cap++){
                    if(buy==1){
                        int take = ((-prices[idx]) + dp[idx+1][0][cap]);
                        int notTake = (0 + dp[idx+1][1][cap]);
                        dp[idx][buy][cap] = Math.max(take, notTake);
                    }else{
                        int take = (prices[idx] + dp[idx+1][1][cap-1]);
                        int notTake = (0 + dp[idx+1][0][cap]);
                        dp[idx][buy][cap] = Math.max(take, notTake);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}
