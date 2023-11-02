package dynamic_programming;

import java.util.*;

public class count_subset_with_sum_k {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: "+ findWays(arr, k));
    }

    public static int findWays(int num[], int tar) {
        // Write your code here.
        int n = num.length;
        int dp[][] = new int[n][tar+1];
        // for(int arr[]: dp){
        //     Arrays.fill(arr, -1);
        // }
        // return solve(n-1, tar, num);
        // return solveUsingMemoization(n-1, tar, num, dp);
        return solveUsingTabulation(tar, n, num, dp);
    }
    //Recursive
    public static int solve(int idx, int target, int a[]){
        //base case
        if(target==0){
            return 1;
        }
        if(idx==0){
            if(a[idx] == target){
                return 1;
            }else{
                return 0;
            }
        }
        int nottake = solve(idx-1, target, a);
        int take = 0;
        if(a[idx]<=target){
            take = solve(idx-1, target-a[idx], a);
        }
        return take+ nottake;
    }
    //Memoization
    public static int solveUsingMemoization(int ind, int target, int arr[], int dp[][]){
        //base case
        if (target == 0){
            return 1;
        }
        if (ind == 0){
            return arr[0] == target ? 1 : 0;
        }
        if (dp[ind][target] != -1){
            return dp[ind][target];
        }

        int notTaken = solveUsingMemoization(ind - 1, target, arr, dp);

        int taken = 0;
        if (arr[ind] <= target){
            taken = solveUsingMemoization(ind - 1, target - arr[ind], arr, dp);
        }

        return dp[ind][target] = notTaken + taken;
    }
    //tabulation
    public static int solveUsingTabulation(int k, int n, int num[], int dp[][]){
        //base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (num[0] <= k) {
            dp[0][num[0]] = 1;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                int notTaken = dp[ind - 1][target];

                int taken = 0;
                if (num[ind] <= target) {
                    taken = dp[ind - 1][target - num[ind]];
                }

                dp[ind][target] = notTaken + taken;
            }
        }

        return dp[n - 1][k];
    }
}
