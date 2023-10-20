package dynamic_programming;

import java.util.*;

public class unique_paths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println("Answer is: " + uniquePaths(m, n));
    }
    public static int uniquePaths(int m, int n) {
		// Write your code here. 
		// return solve(m-1,n-1);
		int dp[][] = new int[m][n];
		for(int a[]: dp){
			Arrays.fill(a,-1);
		}
		// return solveUsingMemoization(m-1,n-1,dp);
		return solveUsingTabulation(m,n,dp);
	}
    public static int solve(int i, int j){
		//base case
		if(i==0 && j==0){
			return 1;
		}
		if(i<0 || j<0){
			return 0;
		}
		int up = solve(i-1,j);
		int left = solve(i,j-1);

		return up + left;
	}
	//memoization
	public static int solveUsingMemoization(int i, int j, int dp[][]){
		//base case
		if(i==0 && j==0){
			return 1;
		}
		if(i<0 || j<0){
			return 0;
		}
		if(dp[i][j]!=-1){
			return dp[i][j];
		}
		int up = solveUsingMemoization(i-1,j,dp);
		int left = solveUsingMemoization(i,j-1,dp);
		return dp[i][j] = up+left;
	}
	//tabulation
	public static int solveUsingTabulation(int m, int n, int dp[][]){
		//convert the base case
		dp[0][0] = 1;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(i==0 && j==0){
					continue;
				}
				int up = 0;
				int left = 0;
				if(i>0){
					up = dp[i-1][j];
				}
				if(j>0){
					left = dp[i][j-1];
				}
				dp[i][j] = up + left;
			}
		}
		return dp[m-1][n-1];
	}
}
