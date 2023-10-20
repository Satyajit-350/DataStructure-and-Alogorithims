package dynamic_programming;

import java.util.*;

public class minimum_path_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int grid[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println("Answer is: " + minSumPath(grid));
    }
    public static int minSumPath(int[][] grid) {
    	// Write your code here. 
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int arr[]: dp){
            Arrays.fill(arr,-1);
        }
        // return solve(m-1, n-1, grid);
        // return solveUsingMemoization(m-1,n-1,grid,dp);
        return solveUsingTabulation(m,n,grid,dp);
    }
    //recursive
    public static int solve(int i, int j, int grid[][]){
        //base case
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(i<0 || j<0){
            return (int)(1e9);
        }
        int up = grid[i][j] + solve(i-1, j, grid);
        int left = grid[i][j] + solve(i, j-1, grid);
        return Math.min(up,left);
    }
    //Memoization
    public static int solveUsingMemoization(int i, int j, int grid[][], int dp[][]){
        //base case
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(i<0 || j<0){
            return (int)(1e9);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up = grid[i][j] + solveUsingMemoization(i-1, j, grid, dp);
        int left = grid[i][j] + solveUsingMemoization(i, j-1, grid, dp);
        return dp[i][j] = Math.min(up,left);
    }
    //tabulation
    public static int solveUsingTabulation(int m, int n, int grid[][], int dp[][]){
        dp[0][0] = grid[0][0];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    dp[i][j] = grid[i][j];
                }else{
                    int up = 0;
                    int left = 0;
                    if(i>0){
                        up = grid[i][j] + dp[i-1][j];
                    }else{
                        up = grid[i][j] + (int)(1e9);
                    }
                    if(j>0){
                        left = grid[i][j] + dp[i][j-1];
                    }else{
                        left = grid[i][j] + (int)(1e9);
                    }
                    dp[i][j] = Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
