package dynamic_programming;

import java.util.*;

public class wildcard_matching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println("Answer is: " + wildcardMatching(s1, s2));
    }
    public static boolean wildcardMatching(String pattern, String text) {
		// Write your code here.
		int n = pattern.length();
		int m = text.length();
		int dp[][] = new int[n][m];
		for(int a[]: dp){
			Arrays.fill(a,-1);
		}
		boolean dp1[][] = new boolean[n+1][m+1];
		// return solve(n-1,m-1,pattern,text);
		// return solveUsingMemoization(n-1,m-1,pattern,text,dp);
		return solveUsingTabulaton(n,m,pattern,text,dp1);
	}
	//Recursive
	public static boolean solve(int i, int j, String s1, String s2){
		//base case
		if(i<0 & j<0){
			return true;
		}
		if(i<0 && j>=0){
			return false;
		}
		if(j<0 && i>=0){
			for(int k=0; k<=i; k++){
				if(s1.charAt(k)!='*'){
					return false;
				}
			}
			return true;
		}
		if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
			return solve(i-1,j-1,s1,s2);
		}
		if(s1.charAt(i) == '*'){
			return solve(i-1, j, s1, s2) | solve(i, j-1, s1, s2);
		}
		return false;
	}
	//Memoization
	public static boolean solveUsingMemoization(int i, int j, String s1, String s2, int dp[][]){
		//base case
		if(i<0 & j<0){
			return true;
		}
		if(i<0 && j>=0){
			return false;
		}
		if(j<0 && i>=0){
			for(int k=0; k<=i; k++){
				if(s1.charAt(k)!='*'){
					return false;
				}
			}
			return true;
		}
		if(dp[i][j]!=-1){
			return (dp[i][j]==1)?true:false;
		}
		if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
			dp[i][j] = (solveUsingMemoization(i-1,j-1,s1,s2, dp))?1:0;
			return (solveUsingMemoization(i-1,j-1,s1,s2, dp));
		}
		if(s1.charAt(i) == '*'){
			dp[i][j] = (solveUsingMemoization(i-1, j, s1, s2, dp) | solveUsingMemoization(i, j-1, s1, s2, dp))?1:0;
			return (solveUsingMemoization(i-1, j, s1, s2, dp) | solveUsingMemoization(i, j-1, s1, s2, dp));
		}
		dp[i][j] = 0;
		return false;
	}
	//Tabulation
	public static boolean solveUsingTabulaton(int n, int m, String s1, String s2, boolean dp[][]){
		dp[0][0] = true;
		for(int j=1; j<=m; j++){
			dp[0][j] = false;
		}
		for(int i=1; i<=n; i++){
			boolean flag = true;
			for(int k=1; k<=i; k++){
				if(s1.charAt(k-1)!='*'){
					flag =  false;
					break;
				}
			}
			dp[i][0] = flag;
		}
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
					dp[i][j] = dp[i-1][j-1];
				}else if(s1.charAt(i-1) == '*'){
					dp[i][j] = dp[i-1][j] | dp[i][j-1];
				}else{
					dp[i][j] = false;
				}
			}
		}
		return dp[n][m];
	}
}
