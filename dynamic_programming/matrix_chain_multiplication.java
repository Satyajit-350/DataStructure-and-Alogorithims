package dynamic_programming;

import java.util.*;

public class matrix_chain_multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + mcm(arr));
    }
    public static int mcm(int[] p){
        int n = p.length;
        int dp[][] = new int[n][n];
        for(int a[]: dp){
            Arrays.fill(a,-1);
        }
        // return solve(1, n-1, p);
        return solveUsingMemoization(1, n-1, p, dp);
        // return solveUsingTabulation(n, p, dp);
    }
    //Recursive
    public static int solve(int i, int j, int arr[]){
        //base case
        if(i==j) return 0;
        int min = (int)(1e9);
        for(int k=i; k<j; k++){
            int steps = (arr[i-1] * arr[k] * arr[j]) + solve(i, k, arr) + solve(k+1, j, arr);
            min = Math.min(min, steps);
        }
        return min;
    }
    //Memoization
    public static int solveUsingMemoization(int i, int j, int arr[], int dp[][]){
        //base case
        if(i==j) return 0;
        if(dp[i][j]!=-1){
                return dp[i][j];
        }
        int min = (int)(1e9);
        for(int k=i; k<j; k++){
            int steps = (arr[i-1] * arr[k] * arr[j])
                + solveUsingMemoization(i, k, arr, dp) + solveUsingMemoization(k+1, j, arr, dp);
            min = Math.min(min, steps);
        }
        return dp[i][j] = min;
    }
    //Tabulation
    public static int solveUsingTabulation(int n, int arr[], int dp[][]){
        for(int i=1; i<n; i++){
            dp[i][i] = 0;
        }
        for(int i=n-1; i>=1; i--){
            for(int j=i+1; j<n; j++){
                int min = (int)(1e9);
                for(int k=i; k<j; k++){
                    int steps = (arr[i-1] * arr[k] * arr[j])+ dp[i][k] + dp[k+1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n-1];
    }
}
