package array;

import java.util.*;

public class trafic_flow {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int currX = sc.nextInt();
        int currY = sc.nextInt();

        int finalX = sc.nextInt();
        int finalY = sc.nextInt();

        int ans = solve(arr, currX-1, currY-1, finalX-1, finalY-1);
        System.out.println(ans);

    }

    private static int solve(int[][] grid, int currX, int currY, int finalX, int finalY) {
        int m = grid.length;
        int n = grid[0].length;
        if(currX>m || currY>n || finalX>m || finalY>n){
            return -1;
        }
        int dp[][] = new int[m][n];
        for(int arr[]: dp){
            Arrays.fill(arr,-1);
        }
        // int ans = solve1(finalX, finalY, currX, currY, grid);
        int ans = solveUsingMemoization(finalX, finalY, currX, currY, grid, dp);
        if(ans == (int)(1e9)){
            return -1;
        }else{
            return ans;
        }
    }
    public static int solve1(int i, int j, int currX, int currY, int grid[][]){
        //base case
        if(i==currX&& j==currY){
            return grid[i][j];
        }
        if(i<currX || j<currY){
            return (int)(1e9);
        }
        int up = grid[i][j] + solve1(i-1, j, currX, currY, grid);
        int left = grid[i][j] + solve1(i, j-1, currX, currY, grid);
        return Math.min(up,left);
    }
    public static int solveUsingMemoization(int i, int j, int currX, int currY, int grid[][], int dp[][]){
        //base case
        if(i==currX && j==currY){
            return grid[i][j];
        }
        if(i<0 || j<0){
            return (int)(1e9);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up = grid[i][j] + solveUsingMemoization(i-1, j, currX, currY, grid, dp);
        int left = grid[i][j] + solveUsingMemoization(i, j-1, currX, currY, grid, dp);
        return dp[i][j] = Math.min(up,left);
    }
}
