package dynamic_programming;

import java.util.*;

public class minimum_path_sum_triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Answer is: "+ minimumPathSum(arr, n));
    }
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here. 
        int dp[][] = new int[n][n];
        for(int arr[]: dp){
            Arrays.fill(arr,-1);
        }
        // return solve(0,0,n,triangle);
        // return solveUsingMemoization(0,0,n,triangle,dp);
        return solveUsingTabulation(n,triangle,dp);
    }
    //recursive
    public static int solve(int i, int j, int n, int a[][]){
        //base case
        if(i==n-1){
            return a[n-1][j];
        }
        int down = a[i][j] + solve(i+1,j,n,a);
        int diag = a[i][j] + solve(i+1,j+1,n,a);
        return Math.min(down,diag);
    }
    //memoization
    public static int solveUsingMemoization(int i, int j, int n, int a[][], int dp[][]){
        //base case
        if(i==n-1){
            return a[n-1][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down = a[i][j] + solveUsingMemoization(i+1,j,n,a,dp);
        int diag = a[i][j] + solveUsingMemoization(i+1,j+1,n,a,dp);
        return dp[i][j] = Math.min(down,diag);
    }
    //tabulation
    public static int solveUsingTabulation(int n, int a[][], int dp[][]){
        //base case
        for(int j=0; j<n; j++){
            dp[n-1][j] = a[n-1][j];
        }
        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int down = a[i][j] + dp[i+1][j];
                int diag = a[i][j] + dp[i+1][j+1];
                dp[i][j] = Math.min(down,diag);
            }
        }
        return dp[0][0];
    }
}
