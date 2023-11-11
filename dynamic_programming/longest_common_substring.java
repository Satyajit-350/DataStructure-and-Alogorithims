package dynamic_programming;

import java.util.*;

public class longest_common_substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println("Answer is: "+ lcs(s1, s2));
    }

    public static int lcs(String str1, String str2){
        // Write your code here.
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int a[]: dp){
            Arrays.fill(a,-1);
        }
        return solveUsingTabulation(n, m, str1, str2, dp);
    }
    public static int solveUsingTabulation(int n, int m, String s, String t, int dp[][]){
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }
        int max = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    max = Math.max(max,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
