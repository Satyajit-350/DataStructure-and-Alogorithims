package dynamic_programming;

import java.util.*;

public class distinct_subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println("Answer is: " + distinctSubsequences(s, t));
    }
    public static int distinctSubsequences(String str, String sub) {
        // Write your code here.
        int n = str.length();
        int m = sub.length();
        int dp[][] = new int[n+1][m+1];
        for(int a[]: dp){
            Arrays.fill(a,-1);
        }
        // return solve(n-1, m-1, str, sub);
        // return solveUsingMemoization(n-1, m-1, str, sub, dp);
        return solveUsingTabulation(n, m, str, sub, dp);
    }
    //Recursive
    public static int solve(int i, int j, String s1, String s2){
        //base case
        if(j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return solve(i-1, j-1, s1, s2) + solve(i-1, j, s1, s2);
        }else{
            return solve(i-1, j, s1, s2);
        }
    }
    //Memoization
    public static int solveUsingMemoization(int i, int j, String s1, String s2, int dp[][]){
        //base case
        if(j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = (solveUsingMemoization(i-1, j-1, s1, s2, dp) + solveUsingMemoization(i-1, j, s1, s2, dp))%1000000007;
        }else{
            return dp[i][j] = solveUsingMemoization(i-1, j, s1, s2, dp) % 1000000007;
        }
    }
    public static int solveUsingTabulation(int n, int m, String s1, String s2, int dp[][]){
        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%1000000007;
                }else{
                    dp[i][j] = dp[i-1][j]%1000000007;
                }
            }
        }
        return dp[n][m];
    }
}
