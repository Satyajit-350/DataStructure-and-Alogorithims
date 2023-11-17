package dynamic_programming;

import java.util.*;

public class cuts_into_segment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        System.out.println("Answer is: " + cutSegments(n, x, y, z));
    }
    public static int cutSegments(int n, int x, int y, int z) {
        // Write your code here.
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
       
    //   return solve(n,x,y,z);
        // int ans = solveUsingMemoization(n,x,y,z,dp);
        // return (ans<0)?0:ans;
        return solveUsingTabulation(n,x,y,z,dp);
    }
    //Recursive
    public static int solve(int n, int x, int y, int z){
        //base case
        if(n<0){
            return (int)(-1e9);
        }
        if(n==0){
            return 0;
        }
        int c1 = 1 + solve(n-x, x, y, z);
        int c2 = 1 + solve(n-y, x, y, z);
        int c3 = 1 + solve(n-z, x, y, z);
        
        return Math.max(c1, Math.max(c2, c3));
    }
    //Memoization
    public static int solveUsingMemoization(int n, int x, int y, int z, int dp[]){
        //base case
        if(n<0){
            return (int)(-1e9);
        }
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int c1 = 1 + solveUsingMemoization(n-x, x, y, z,dp);
        int c2 = 1 + solveUsingMemoization(n-y, x, y, z, dp);
        int c3 = 1 + solveUsingMemoization(n-z, x, y, z, dp);
        
        return dp[n] = Math.max(c1, Math.max(c2, c3));
    }
    //Tabulation
    public static int solveUsingTabulation(int n, int x, int y, int z, int dp[]){
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            int c1 = -1;
            int c2 = -1;
            int c3 = -1;
            if(i-x>=0 && dp[i-x]!=-1){
                c1 = 1 + dp[i-x];
            }
            if(i-y>=0 && dp[i-y]!=-1){
                c2 = 1 + dp[i-y];
            }
            if(i-z>=0 && dp[i-z]!=-1){
                c3 = 1 + dp[i-z];
            }
            dp[i] = Math.max(c1, Math.max(c2, c3));
        }
        return dp[n] < 0 ? 0: dp[n];
    }
}
