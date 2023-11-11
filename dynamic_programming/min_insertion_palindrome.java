package dynamic_programming;

import java.util.*;

public class min_insertion_palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("Answer is: " + minInsertions(str));
    }
    public static int minInsertions(String s) {
        return s.length()-longestPalindromeSubsequence(s);
    }
    public static int longestPalindromeSubsequence(String s) {
		// Write your code here.
		int n = s.length();
		StringBuilder sb = new StringBuilder(s);
		String t = sb.reverse().toString(); 
		int m = t.length();
		int dp[][] = new int[n+1][m+1];
        for(int a[]: dp){
            Arrays.fill(a,-1);
        }
        return solveUsingTabulation(n, m, s, t, dp);
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
