package dynamic_programming;

import java.util.*;

public class longest_common_subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println("Answer is: "+ lcs(s, t));
    }
    public static int lcs(String s, String t) {
		//Your code goes here
		int n = s.length();
		int m = t.length();
		int dp[][] = new int[n+1][m+1];
		for(int a[]: dp){
			Arrays.fill(a,-1);
		}
		// return solve(n-1, m-1, s, t);
		// return solveUsingMemoization(n, m, s, t, dp);
		return solveUsingTabulation(n, m, s, t, dp);
    }
	//recursive
	public static int solve(int i, int j, String s, String t){
		//base case
		if(i<0 || j<0){
			return 0;
		}
		if(s.charAt(i)==t.charAt(j)){
			return 1 + solve(i-1,j-1,s,t);
		}
		return 0 + Math.max(solve(i-1,j,s,t), solve(i,j-1,s,t));
	}
	//Memoization
	public static int solveUsingMemoization(int i, int j, String s, String t, int dp[][]){
		//by shifting the index previously i was n-1 and j was m-1 
		//but here after shifting index i=n and j=m so accordingly change the conditions
		
		//base case
		if(i==0 || j==0){
			return 0;
		}
		if(dp[i][j]!=-1){
			return dp[i][j];
		}
		if(s.charAt(i-1) == t.charAt(j-1)){
			return dp[i][j] = 1 + solveUsingMemoization(i-1, j-1, s, t, dp);
		}
		return dp[i][j] = 0 + Math.max(solveUsingMemoization(i-1, j, s, t, dp), solveUsingMemoization(i, j-1, s, t, dp));
	}
	//Tabulation
	public static int solveUsingTabulation(int n, int m, String s, String t, int dp[][]){
		for(int i=0; i<=n; i++){
			dp[i][0] = 0;
		}
		for(int j=0; j<=m; j++){
			dp[0][j] = 0;
		}
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				if(s.charAt(i-1) == t.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
				}	
			}
		}
		return dp[n][m];
	}
}
