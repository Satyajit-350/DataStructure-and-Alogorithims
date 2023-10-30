package dynamic_programming;

import java.util.*;

/**
 * This question is exact the same question i.e., Subset Sum Equals to k 
 */
public class partition_equal_subset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + canPartition(arr));
    }
    public static boolean canPartition(int[] nums) {
        int n= nums.length;
        int totSum = 0;
		for(int e: nums){
			totSum += e;
		}
		//base case
		if(totSum%2!=0){
			return false;
		}
		int target = totSum/2;
		
		return subsetSumToK(n, target, nums);
    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int dp[][] = new int[n+1][k+1];
        boolean dp1[][] = new boolean[n][k+1];
        for(int a[]: dp){
            Arrays.fill(a,-1);
        }
        // return solve(n-1, k, arr);
        // return solveUsingMemoization(n-1,k,arr,dp);
        return solveUsingTabulation(n, k, arr, dp1);
    }
    //Recursive
    public static boolean solve(int idx, int target, int a[]){
        //base case
        if(target==0){
            return true;
        }
        if(idx==0){
            return a[0]==target;
        }
        //not pick case
        boolean not_pick = solve(idx-1, target, a);
        //pick case
        boolean pick = false;
        if(target>=a[idx]){
            pick = solve(idx-1, target-a[idx], a);
        }
        return (pick || not_pick);
    }
    //Memoization
    public static boolean solveUsingMemoization(int idx, int target, int a[], int dp[][]){
        //base case
        if(target==0){
            return true;
        }
        if(idx==0){
            return a[0]==target;
        }
        if(dp[idx][target]!=-1){
            return (dp[idx][target]==0)?true:false;
        }
        //not pick case
        boolean not_pick = solveUsingMemoization(idx-1, target, a, dp);
        //pick case
        boolean pick = false;
        if(target>=a[idx]){
            pick = solveUsingMemoization(idx-1, target-a[idx], a, dp);
        }
        boolean res = pick || not_pick;
        if(res){
            dp[idx][target] = 0;
        }else{
            dp[idx][target] = 1;
        }
        return res;
    }
    //Tabulation
    public static boolean solveUsingTabulation(int n, int k, int a[], boolean dp[][]){
        //base case
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        if(a[0]<=k){
            dp[0][a[0]] = true;
        }
        for(int i=1; i<n; i++){
            for(int target=1; target<=k; target++){
                //not pick case
                boolean not_take = dp[i-1][target];
                //pick case
                boolean take = false;
                if(target>=a[i]){
                    take = dp[i-1][target-a[i]];
                }
                dp[i][target] = take||not_take;
            }
        }
        return dp[n-1][k];
    }

}
