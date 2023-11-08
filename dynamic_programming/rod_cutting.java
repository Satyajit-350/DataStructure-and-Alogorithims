package dynamic_programming;

import java.util.*;

public class rod_cutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int price[] = new int[n];
        for(int i=0; i<n; i++){
            price[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + cutRod(price, n));
    }
    public static int cutRod(int price[], int n) {
		// Write your code here.
		int dp[][] = new int[price.length][n+1];
		for(int a[]: dp){
			Arrays.fill(a,-1);
		}
		// return solve(price.length-1, n, price);
		return solveUsingMemoization(price.length-1, n, price, dp);
		// return solveUsingTabulation(price.length, n, price, dp);
	}
	//recursive
	public static int solve(int idx, int N, int price[]){
		//base case
		if(idx==0){
			return N * price[0];
		}
		int not_take = 0 + solve(idx-1, N, price);
		int take = (int)(-1e9);
		if((idx+1) <= N){
			take = price[idx] + solve(idx, N-(idx+1), price);
		}
		return Math.max(take, not_take);
	}
	//Memoization
	public static int solveUsingMemoization(int idx, int N, int price[], int dp[][]){
		//base case
		if(idx==0){
			return N * price[0];
		}
		if(dp[idx][N]!=-1){
			return dp[idx][N];
		}
		int not_take = 0 + solveUsingMemoization(idx-1, N, price, dp);
		int take = (int)(-1e9);
		if((idx+1) <= N){
			take = price[idx] + solveUsingMemoization(idx, N-(idx+1), price,dp);
		}
		return dp[idx][N] = Math.max(take, not_take);
	}
	//Tabulation
	public static int solveUsingTabulation(int n, int N, int price[], int dp[][]){
		for(int len=0; len<=N; len++){
			dp[0][len] = len * price[0];
		}
		for(int i=1; i<n; i++){
			for(int len=0; len<=N; len++){
				int not_take = 0 + dp[i-1][len];
				int take = (int)(-1e9);
				if((i+1) <= len){
					take = price[i] + dp[i][len-(i+1)];
				}
				dp[i][len] = Math.max(take, not_take);
			}
		}
		return dp[n-1][N];
	}
}
