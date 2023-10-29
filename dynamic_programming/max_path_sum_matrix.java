package dynamic_programming;

import java.util.*;

/**
 * In this Question it has variable starting point and variable ending points
 */

public class max_path_sum_matrix {
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
        System.out.println("Answer is: " + getMaxPathSum(arr));
    }

    public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
		int n = matrix.length;
		int m = matrix[0].length;
		int dp[][] = new int[n][m];
		for(int arr[]: dp){
			Arrays.fill(arr,-1);
		}
		// int max = (int)(-1e9);
		// for(int j=0; j<m; j++){
		// 	// max = Math.max(max, solve(n-1, j, n, m, matrix));
		// 	max = Math.max(max, solveUsingMemoization(n-1, j, n, m, matrix, dp));
		// }
		// return max;
		return solveUsingTabulation(n, m, matrix, dp);
	}
	//Recursive
	public static int solve(int i, int j, int n, int m, int a[][]){
		//base case
		if(j<0 || j>=m){
			return (int)(-1e9);
		}
		if(i==0){
			return a[0][j];
		}
		int top = a[i][j] + solve(i-1, j, n, m, a);
		int leftDiag = a[i][j] + solve(i-1, j-1, n, m, a);
		int rightDiag = a[i][j] + solve(i-1, j+1, n, m, a);
		return Math.max(Math.max(top, leftDiag), rightDiag);
	}
	//Memoization
	public static int solveUsingMemoization(int i, int j, int n, int m, int a[][], int dp[][]){
		//base case
		if(j<0 || j>=m){
			return (int)(-1e9);
		}
		if(i==0){
			return a[0][j];
		}
		if(dp[i][j]!=-1){
			return dp[i][j];
		}
		int top = a[i][j] + solveUsingMemoization(i-1, j, n, m, a, dp);
		int leftDiag = a[i][j] + solveUsingMemoization(i-1, j-1, n, m, a, dp);
		int rightDiag = a[i][j] + solveUsingMemoization(i-1, j+1, n, m, a, dp);
		return dp[i][j] = Math.max(Math.max(top, leftDiag), rightDiag);
	}
	public static int solveUsingTabulation(int n, int m, int a[][], int dp[][]){
		for(int j=0; j<m; j++){
			dp[0][j] = a[0][j];
		}
		for(int i=1; i<n; i++){
			for(int j=0; j<m; j++){
				int top = a[i][j] + dp[i-1][j];
				int leftDiag = a[i][j];
				int rightDiag = a[i][j];
				if(j-1>=0){
					leftDiag += dp[i-1][j-1];
				}else{
					leftDiag += (int)(-1e9);
				}
				if(j+1<m){
					rightDiag += dp[i-1][j+1];
				}else{
					rightDiag += (int)(-1e9);
				}
				dp[i][j] = Math.max(top, Math.max(leftDiag, rightDiag));
			}
		}
		int max = dp[n-1][0];
		for(int j=1; j<m; j++){
			max = Math.max(max,dp[n-1][j]);
		}
		return max;
	}

}
