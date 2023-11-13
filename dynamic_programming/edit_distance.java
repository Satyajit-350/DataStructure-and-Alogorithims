package dynamic_programming;

import java.util.*;

public class edit_distance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println("Answer is: " + minDistance(s, t));
    }
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int a[]: dp){
            Arrays.fill(a,-1);
        }
        // return solve(n-1, m-1, word1, word2);
        // return solveUsingMemoization(n-1, m-1, word1, word2, dp);
        return solveUsingTabulation(n,m,word1,word2,dp);
    }
    //recursive
    public static int solve(int i, int j, String s1, String s2){
        //base case
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return 0 + solve(i-1, j-1, s1, s2);
        }else{
            int insert = 1 + solve(i, j-1, s1, s2);
            int delete = 1 + solve(i-1, j, s1, s2);
            int replace = 1 + solve(i-1, j-1, s1, s2);
            return Math.min(insert, Math.min(delete, replace));
        }
    }
    //memoization
    public static int solveUsingMemoization(int i, int j, String s1, String s2, int dp[][]){
        //base case
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 0 + solveUsingMemoization(i-1, j-1, s1, s2, dp);
        }else{
            int insert = 1 + solveUsingMemoization(i, j-1, s1, s2, dp);
            int delete = 1 + solveUsingMemoization(i-1, j, s1, s2, dp);
            int replace = 1 + solveUsingMemoization(i-1, j-1, s1, s2, dp);
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }
    //tabulation
    public static int solveUsingTabulation(int n, int m, String s1, String s2, int dp[][]){
        for(int j=0; j<=m; j++){
            dp[0][j] = j;
        }
        for(int i=0; i<=n; i++){
            dp[i][0] = i;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 0 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min((1 + dp[i][j-1]), Math.min((1+dp[i-1][j]), (1+dp[i-1][j-1])));
                }
            }
        }
        return dp[n][m];
    }
}
