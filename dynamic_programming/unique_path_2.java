package dynamic_programming;

import java.util.*;

public class unique_path_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int grid[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println("Anser is: "+ uniquePathsWithObstacles(grid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int a[]: dp){
            Arrays.fill(a,-1);
        }
        // return solveUsingMemoization(m-1,n-1,dp,obstacleGrid);
        return solveUsingTabulation(m,n,dp,obstacleGrid);
    }
     //recursive
    public static int solve(int i, int j, int grid[][]){
		//base case
        if(i>=0 && j>=0 && grid[i][j]==1){
            return 0;
        }
		if(i==0 && j==0){
			return 1;
		}
		if(i<0 || j<0){
			return 0;
		}
		int up = solve(i-1,j,grid);
		int left = solve(i,j-1,grid);

		return up + left;
	}
	//memoization
	public static int solveUsingMemoization(int i, int j, int dp[][], int grid[][]){
		//base case
		if(i>=0 && j>=0 && grid[i][j]==1){
				return 0;
		}
		if(i==0 && j==0){
			return 1;
		}
		if(i<0 || j<0){
			return 0;
		}
		if(dp[i][j]!=-1){
			return dp[i][j];
		}
		int up = solveUsingMemoization(i-1,j,dp,grid);
		int left = solveUsingMemoization(i,j-1,dp,grid);
		return dp[i][j] = up+left;
	}
	//tabulation
	public static int solveUsingTabulation(int m, int n, int dp[][], int grid[][]){
		//convert the base case
		dp[0][0] = 1;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(grid[i][j]==1){
						dp[i][j] = 0;
				}else if(i==0 && j==0){
					dp[i][j] = 1;;
				}else{
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
		}
		return dp[m-1][n-1];
	}

}
