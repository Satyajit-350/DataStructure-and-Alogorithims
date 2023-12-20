package dynamic_programming;

import java.util.*;

public class pallindrome_partioning_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("Answer is: " + palindromePartitioning(str));
    }
    public static int palindromePartitioning(String str) {
        // Write your code here
        int n = str.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        // return solve(0, n, str)-1;
        // return solveUsingMemoization(0, n, str, dp)-1;
        return solveUsingTabulation(n, str, dp)-1;
    }
    public static boolean isPallindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    //Recursive
    public static int solve(int i, int n, String str){
        //base case
        if(i==n){
            return 0;
        }
        String temp = "";
        int min = Integer.MAX_VALUE;
        for(int j=i; j<n; j++){
            temp += str.charAt(j);
            if(isPallindrome(str, i, j)){
                int count = 1 + solve(j+1, n, str);
                min = Math.min(min, count);
            }
        }
        return min;
    }
    //Memoization
    public static int solveUsingMemoization(int i, int n, String str, int dp[]){
        //base case
        if(i==n){
            return 0;
        }
        String temp = "";
        int min = Integer.MAX_VALUE;
        if(dp[i]!=-1){
            return dp[i];
        }
        for(int j=i; j<n; j++){
            temp += str.charAt(j);
            if(isPallindrome(str, i, j)){
                int count = 1 + solveUsingMemoization(j+1, n, str, dp);
                min = Math.min(min, count);
            }
        }
        return dp[i] = min;
    }
    //Tabulation
    public static int solveUsingTabulation(int n, String str, int dp[]){
        //base case
        dp[n] = 0;
        for(int i=n-1; i>=0; i--){
            String temp = "";
            int min = Integer.MAX_VALUE;
            for(int j=i; j<n; j++){
                temp += str.charAt(j);
                if(isPallindrome(str, i, j)){
                    int count = 1 + dp[j+1];
                    min = Math.min(min, count);
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }
}
