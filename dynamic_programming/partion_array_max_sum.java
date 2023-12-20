package dynamic_programming;

import java.util.*;

public class partion_array_max_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + maximumSubarray(arr, k));
    }
    public static int maximumSubarray(int arr[], int k) {
        // Write your code here..
        int n =arr.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        // return solve(0, arr, k, n);
        // return solveUsingMemoization(0, arr, k, n, dp);
        return solveUsingTabulation(n, arr, k, dp);
    }
    //Recursive
    public static int solve(int i, int arr[], int k, int n){
        //base case
        if(i==n){
            return 0;
        }
        int len = 0;
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int j=i; j<Math.min(i+k, n); j++){
            len++;
            max = Math.max(max, arr[j]);
            int sum = (len*max) + solve(j+1, arr, k, n);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
    //Memoization
    public static int solveUsingMemoization(int i, int arr[], int k, int n, int dp[]){
        //base case
        if(i==n){
            return 0;
        }
        int len = 0;
        int ans = 0;
        int max = Integer.MIN_VALUE;
        if(dp[i]!=-1){
            return dp[i];
        }
        for(int j=i; j<Math.min(i+k, n); j++){
            len++;
            max = Math.max(max, arr[j]);
            int sum = (len*max) + solveUsingMemoization(j+1, arr, k, n, dp);
            ans = Math.max(ans, sum);
        }
        return dp[i] = ans;
    }
    //Tabulation
    public static int solveUsingTabulation(int n, int arr[], int k, int dp[]){
        //base case
        dp[n] = 0;
        for(int i=n-1; i>=0; i--){
            int len = 0;
            int ans = 0;
            int max = Integer.MIN_VALUE;
            for(int j=i; j<Math.min(i+k, n); j++){
                len++;
                max = Math.max(max, arr[j]);
                int sum = (len*max) + dp[j+1];
                ans = Math.max(ans, sum);
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}
