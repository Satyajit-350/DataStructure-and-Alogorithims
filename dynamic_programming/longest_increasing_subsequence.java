package dynamic_programming;

import java.util.*;

public class longest_increasing_subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        // for(int a[]: dp){
        //     Arrays.fill(a,-1);
        // }
        // return solve(0,-1,n,nums);
        // return solveUsingMemoization(0, -1, n, nums, dp);
        // return solveUsingTabulation(n, nums, dp);
        return solveUsingTabulation2(n, nums);
    }
    //recursive
    public static int solve(int idx, int prev, int n, int arr[]){
        //base case
        if(idx==n){
            return 0;
        }
        //notTake
        int len = 0 + solve(idx+1, prev, n, arr);
        if(prev==-1 || arr[idx] > arr[prev]){
            //take
            len = Math.max(len, (1 + solve(idx+1, idx, n, arr)));
        }
        return len;
    }
    //Memoization
    public static int solveUsingMemoization(int idx, int prev, int n, int arr[], int dp[][]){
        //base case
        if(idx==n){
            return 0;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
        //notTake
        int len = 0 + solveUsingMemoization(idx+1, prev, n, arr, dp);
        if(prev==-1 || arr[idx] > arr[prev]){
            //take
            len = Math.max(len, (1 + solveUsingMemoization(idx+1, idx, n, arr, dp)));
        }
        return dp[idx][prev+1] = len;
    }
    //Tabulation 1 - SC: O(N^2)
	public static int solveUsingTabulation(int n, int arr[], int dp[][]){
	    for(int idx=n-1; idx>=0; idx--){
	        for(int prev=idx-1; prev>=-1; prev--){
	            int len = 0 + dp[idx+1][prev+1];
        		if(prev==-1 || arr[idx] > arr[prev]){
        			//take
        			len = Math.max(len, (1 + dp[idx+1][idx+1]));
        		}
        		dp[idx][prev+1] = len;
	        }
	    }
	    return dp[0][-1+1];
	}
    //Tabulation 2 - SC: O(N)
	public static int solveUsingTabulation2(int n, int arr[]){
	    int dp[] = new int[n];
	    Arrays.fill(dp,1);
	    int max = 1;
	    for(int idx=0; idx<n; idx++){
	        for(int prev=0; prev<=idx-1; prev++){
	            if(arr[prev]<arr[idx]){
	                dp[idx] = Math.max(dp[idx], 1 + dp[prev]);
	            }
	            max = Math.max(max, dp[idx]);
	        }
	    }
	    return max;
	}
}
