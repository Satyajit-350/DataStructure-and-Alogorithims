package dynamic_programming;

import java.util.*;

/**
 * Minimum coin - similar concept of knapsack problem
 */
public class coin_change {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        System.out.println("Answer is: "+ coinChange(coins, amount));
    }
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int a[]: dp){
            Arrays.fill(a,-1);
        }
        //int ans = solve(n-2,amount,coins);
        // int ans = solveUsingMemoization(n-1,amount,coins,dp);
        int ans = solveUsingTabulation(n, amount, coins, dp);
        if(ans == (int)(1e9)){
            return -1;
        }else{
            return ans;
        }
    }
    //Recursive
    public static int solve(int idx, int tar, int num[]){
        //base case
        if(idx==0){
            if(tar%num[idx]==0){
                return tar/num[idx];
            }else{
                return (int)(1e9);
            }
        }
        int not_take = 0 + solve(idx-1, tar, num);
        int take = (int)(1e9);
        if(num[idx]<=tar){
            take = 1 + solve(idx, tar-num[idx], num);
        }
        return Math.min(take, not_take);
    }
    //Memoization
    public static int solveUsingMemoization(int idx, int tar, int num[], int dp[][]){
        //base case
        if(idx==0){
            if(tar%num[0]==0){
                return tar/num[0];
            }else{
                return (int)(1e9);
            }
        }
        if(dp[idx][tar]!=-1){
            return dp[idx][tar];
        }
        int not_take = 0 + solveUsingMemoization(idx-1, tar, num, dp);
        int take = (int)(1e9);
        if(num[idx]<=tar){
            take = 1 + solveUsingMemoization(idx, tar-num[idx], num, dp);
        }
        return dp[idx][tar] = Math.min(take, not_take);
    }
     //Tabulation
    public static int solveUsingTabulation(int n, int tar, int num[], int dp[][]){
        
        for(int T=0; T<=tar; T++){
            if(T%num[0]==0){
                dp[0][T] = T/num[0];
            }else{
                dp[0][T] = (int)(1e9);
            }
        }
        for(int i=1; i<n; i++){
            for(int T=0; T<=tar; T++){
                int not_take = 0 + dp[i-1][T];
                int take = (int)(1e9);
                if(num[i]<=T){
                    take = 1 + dp[i][T-num[i]];
                }
                dp[i][T] = Math.min(take, not_take);
            }
        }
        return dp[n-1][tar];
    }
}
