package dynamic_programming;

import java.util.*;

/**
 * This is exactly same same as knapsack but with slight modification
 * In knapsack we can take the value only once but here we have a inifinite supply of value
 * So concept remains same as per the questions "coin change 2" , "coin change"
 */

public class unbounded_knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int profit[] = new int[n];
        int weight[] = new int[n];
        for(int i=0; i<n; i++){
            profit[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            weight[i] = sc.nextInt();
        }
        System.out.println("Answer is: "+ unboundedKnapsack(n, w, profit, weight));
    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here. 
        int dp[][] = new int[n][w+1];
        for(int a[]: dp){
            Arrays.fill(a, -1);
        }
        // return solve(n-1, w, profit, weight);
        // return solveUsingMemoization(n-1, w, profit, weight, dp);
        return solveUsingTabulation(n, w, profit, weight, dp);
    }
    //Recursive
    public static int solve(int idx, int w, int profit[], int wt[]){
        //base case
        if(idx==0){
            return (w/wt[0]) * profit[0];
        }
        int not_take = 0 + solve(idx-1, w, profit, wt);
        int take = (int)(-1e9);
        if(wt[idx]<=w){
            take = profit[idx] + solve(idx, w-wt[idx], profit, wt);
        }
        return Math.max(take,not_take);
    }
    //Memoization
    public static int solveUsingMemoization(int idx, int w, int profit[], int wt[], int dp[][]){
        //base case
        if(idx==0){
            return (w/wt[0]) * profit[0];
        }
        if(dp[idx][w]!=-1){
            return dp[idx][w];
        }
        int not_take = 0 + solveUsingMemoization(idx-1, w, profit, wt, dp);
        int take = (int)(-1e9);
        if(wt[idx]<=w){
            take = profit[idx] + solveUsingMemoization(idx, w-wt[idx], profit, wt, dp);
        }
        return dp[idx][w] = Math.max(take,not_take);
    }
    //Tabulation
    public static int solveUsingTabulation(int n, int w, int profit[], int weight[], int dp[][]){
        for(int wt=0; wt<=w; wt++){
            dp[0][wt] = (wt/weight[0]) * profit[0];
        }
        for(int i=1; i<n; i++){
            for(int wt=0; wt<=w; wt++){
                int not_take = 0 + dp[i-1][wt];
                int take = (int)(-1e9);
                if(weight[i]<=wt){
                    take = profit[i] + dp[i][wt-weight[i]];
                }
                dp[i][wt] = Math.max(take,not_take);
            }
        }
        return dp[n-1][w];
    }
}
