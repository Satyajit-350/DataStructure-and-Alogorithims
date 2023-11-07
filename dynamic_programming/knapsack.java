package dynamic_programming;

import java.util.*;

public class knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int wt[] = new int[n];
        int val[] = new int[n];
        for(int i=0; i<n; i++){
            wt[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            val[i] = sc.nextInt();
        }
        int w = sc.nextInt();
        System.out.println("Answer is: " + knapSack(w, wt, val, n));
    }
    public static int knapSack(int W, int wt[], int val[], int n) { 
        // your code here 
        int dp[][] = new int[n][W+1];
        // for(int a[]: dp){
        //     Arrays.fill(a,-1);
        // }
        // return solve(n-1, W, wt, val);
        // return solveUsingMemoization(n-1, W, wt, val, dp);
        return solveUsingTabulation(n, W, wt, val, dp);
    } 
    //Recursive
    public static int solve(int idx, int maxWeight, int wt[], int val[]){
        //base case
        if(idx==0){
            if(wt[0]<=maxWeight){
                return val[0];
            }else{
                return 0;
            }
        }
        int not_take = 0 + solve(idx-1, maxWeight, wt, val);
        int take = (int)(-1e9);
        if(wt[idx] <= maxWeight){
            take = val[idx] + solve(idx-1, maxWeight - wt[idx], wt, val);
        }
        return Math.max(take,not_take);
    }
    //Memoization
    public static int solveUsingMemoization(int idx, int maxWeight, int wt[], int val[], int dp[][]){
        //base case
        if(idx==0){
            if(wt[0]<=maxWeight){
                return val[0];
            }else{
                return 0;
            }
        }
        if(dp[idx][maxWeight]!=-1){
            return dp[idx][maxWeight];
        }
        int not_take = 0 + solveUsingMemoization(idx-1, maxWeight, wt, val, dp);
        int take = (int)(-1e9);
        if(wt[idx] <= maxWeight){
            take = val[idx] + solveUsingMemoization(idx-1, maxWeight - wt[idx], wt, val, dp);
        }
        return dp[idx][maxWeight] = Math.max(take,not_take);
    }
    //Tabulation
    public static int solveUsingTabulation(int n, int maxWeight, int wt[], int val[], int dp[][]){
        //base case
        for(int i=wt[0]; i<=maxWeight; i++){
            dp[0][i] = val[0];
        }

        for(int idx=1; idx<n; idx++){
            for(int w=0; w<=maxWeight; w++){
                int not_take = 0 + dp[idx-1][w];
                int take = (int)(-1e9);
                if(wt[idx] <= w){
                    take = val[idx] + dp[idx-1][w-wt[idx]]; 
                }
                dp[idx][w] = Math.max(take,not_take);
            }
        }
        return dp[n-1][maxWeight];
    }
}
