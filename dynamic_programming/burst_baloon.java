package dynamic_programming;

import java.util.*;

public class burst_baloon {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + burstBalloons(arr));
    }
     public static int burstBalloons(int []arr){
        // Write your code here. 
        int n = arr.length;
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(1);
        for(int e: arr){
            lis.add(e);
        }
        lis.add(1);
        int dp[][] = new int[n+1][n+1];
        for(int a[]: dp){
            Arrays.fill(a,-1);
        }
        int dp1[][] = new int[n+2][n+2];
        // return solve(1, n, lis);
        // return solveUsingMemoization(1,n,lis,dp);
        return solveUsingTabulation(n, lis, dp1);
    }
    //Recursive
    public static int solve(int i, int j, ArrayList<Integer> a){
        //base case
        if(i>j){
            return 0;
        }
        int max = (int)(-1e9);
        for(int ind=i; ind<=j; ind++){
            int cost = a.get(i-1) * a.get(ind) * a.get(j+1) + solve(i, ind-1, a) + solve(ind+1, j, a);
            max = Math.max(max, cost);
        }
        return max;
    }
    //Memoization
    public static int solveUsingMemoization(int i, int j, ArrayList<Integer> a, int dp[][]){
        //base case
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int max = (int)(-1e9);
        for(int ind=i; ind<=j; ind++){
            int cost = a.get(i-1) * a.get(ind) * a.get(j+1) + 
            solveUsingMemoization(i, ind-1, a, dp) + solveUsingMemoization(ind+1, j, a, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }
    //Tabulation
    public static int solveUsingTabulation(int n, ArrayList<Integer> a, int dp[][]){
        for(int i=n; i>=1; i--){
            for(int j=1; j<=n; j++){
                if(i>j) continue;
                int max = (int)(-1e9);
                for(int ind=i; ind<=j; ind++){
                    int cost = a.get(i-1) * a.get(ind) * a.get(j+1) + 
                    dp[i][ind-1] + dp[ind+1][j];
                    max = Math.max(max, cost);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }
}
