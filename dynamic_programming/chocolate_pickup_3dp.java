package dynamic_programming;

import java.util.*;

/**
 * This Question is to get an overview of 3D Dp
 */

public class chocolate_pickup_3dp {
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
        System.out.println("Answer is: "+ maximumChocolates(n, m, arr));
    }
    public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		int dp[][][] = new int[r][c][c];
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				for(int k=0; k<c; k++){
					dp[i][j][k] = -1;
				}
			}
		}
		// return solve(0,0,c-1,r,c,grid);
		// return solveUsingMemoization(0,0,c-1,r,c,grid,dp);
		return solveUsingTabulation(r,c,grid,dp);
	}
	//Recursive
	public static int solve(int i, int j1, int j2, int n, int m, int a[][]){
		//base case
		if(j1<0 || j1>=m || j2<0 || j2>=m){
			return (int)(-1e9);
		}
		if(i==n-1){
			//check for same coloumn
			if(j1==j2){
				return a[i][j1];
			}else{
				return a[i][j1]+ a[i][j2];
			}
		}
		int max = (int)(-1e9);
		//traverse/ explre all paths
		for(int dj1=-1; dj1<=1; dj1++){
			for(int dj2=-1; dj2<=1; dj2++){
				if(j1==j2){
					max = Math.max(max, (a[i][j1] + solve(i+1, j1+dj1, j2+dj2, n, m, a)));
				}else{
					max = Math.max(max, (a[i][j1] + a[i][j2] + solve(i+1, j1+dj1, j2+dj2, n, m ,a)));
				}
			}
		}
		return max;
	}
	//Memoization
	public static int solveUsingMemoization(int i, int j1, int j2, int n, int m, int a[][], int dp[][][]){
		//base case
		if(j1<0 || j1>=m || j2<0 || j2>=m){
			return (int)(-1e9);
		}
		if(i==n-1){
			//check for same coloumn
			if(j1==j2){
				return a[i][j1];
			}else{
				return a[i][j1]+ a[i][j2];
			}
		}
		if(dp[i][j1][j2] != -1){
			return dp[i][j1][j2];
		}
		int max = (int)(-1e9);
		//traverse/ explre all paths
		for(int dj1=-1; dj1<=1; dj1++){
			for(int dj2=-1; dj2<=1; dj2++){
				if(j1==j2){
					max = Math.max(max, (a[i][j1] + solveUsingMemoization(i+1, j1+dj1, j2+dj2, n, m, a, dp)));
				}else{
					max = Math.max(max, (a[i][j1] + a[i][j2] + solveUsingMemoization(i+1, j1+dj1, j2+dj2, n, m, a, dp)));
				}
			}
		}
		return dp[i][j1][j2]= max;
	}
	//Tabulation
	public static int solveUsingTabulation(int n, int m, int a[][], int dp[][][]){
		//base case
		for(int j1=0; j1<m; j1++){
			for(int j2=0; j2<m; j2++){
				if(j1==j2){
					dp[n-1][j1][j2] = a[n-1][j1];
				}else{
					dp[n-1][j1][j2] = a[n-1][j2] + a[n-1][j1];
				}
			}
		}
		for(int i=n-2; i>=0; i--){
			for(int j1=0; j1<m; j1++){
				for(int j2=0; j2<m; j2++){
					int max = (int)(-1e9);
					for(int dj1=-1; dj1<=1; dj1++){
						for(int dj2=-1; dj2<=1; dj2++){
							int value = 0;
							if(j1==j2){
								value = a[i][j1];
							}else{
								value = a[i][j1] + a[i][j2];
							}
							if((j1+dj1)>=0 && (j1+dj1)<m &&(j2+dj2)>=0 && (j2+dj2)<m){
								value += dp[i+1][j1+dj1][j2+dj2];
							}else{
								value += (int)(-1e9);
							}
							max = Math.max(max, value);
						}
					}
					dp[i][j1][j2]= max;
				}
			}
		}
		return dp[0][0][m-1];
	}
}
