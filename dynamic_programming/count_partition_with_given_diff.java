package dynamic_programming;

import java.util.*;

/**
 * This Question is completely similar to "Count Subset with given k"
 */

public class count_partition_with_given_diff {
    public static void main(String[] args) {
        //basically it is asked we will divide the array into two subset S1 and S2 such that the 
        //Sum of difference of both subset equal to D(difference) i.e., S1-S2 == D ;S1>S2

        //trick is totalSum = S1 + S2  => S1 = totalSum - S2
        //therefore putting in the equation -> totalSum - S2 -S2 = D 
        // totalSum - D = 2S2  => S2 = (totalSum - D) / 2  this is our target
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int d = sc.nextInt();
        int ans = countPartitions(n, d, arr);
        System.out.println(ans);
    }

    public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here. 
		int total_sum = 0;
		for(int e: arr){
			total_sum += e;
		}
		int target = total_sum - d;
		//edge case
		if((target)<0 || (target)%2 !=0){
			return 0;
		}
		int tar = target/2;
		int dp[][] = new int[n][tar+1];
        // for(int ar[]: dp){
        //     Arrays.fill(ar, -1);
        // }
		// return solve(n-1, tar/2, arr);
		return solveUsingMemoization(n-1, tar, arr, dp);
        // return solveUsingTabulation(tar, n, arr, dp);
	}
	//Recursive
    public static int solve(int idx, int target, int a[]){
        //base case
        if(idx==0){
            if(target==0 && a[0] == 0){
                return 2;
            }
            if(target==0 || a[0] == target){
                return 1;
            }
            return 0;
        }
        int nottake = solve(idx-1, target, a);
        int take = 0;
        if(a[idx]<=target){
            take = solve(idx-1, target-a[idx], a);
        }
        return (take+ nottake) % 1000000007;
    }
	public static int solveUsingMemoization(int idx, int target, int a[], int dp[][]){
        //base case
        if(idx==0){
            if(target==0 && a[0] == 0){
                return 2;
            }
            if(target==0 || a[0] == target){
                return 1;
            }
            return 0;
        }
		if(dp[idx][target]!=-1){
			return dp[idx][target];
		}
        int nottake = solveUsingMemoization(idx-1, target, a, dp);
        int take = 0;
        if(a[idx]<=target){
            take = solveUsingMemoization(idx-1, target-a[idx], a, dp);
        }
        return dp[idx][target] = (take+ nottake) % 1000000007;
    }
    //tabulation
    public static int solveUsingTabulation(int k, int n, int num[], int dp[][]){
        //base case
        if (num[0] == 0) {
            dp[0][0] = 2;
        }else{
            dp[0][0] = 1;
        }
        if (num[0]!=0 && num[0] <= k) {
            dp[0][num[0]] = 1;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                int notTaken = dp[ind - 1][target];

                int taken = 0;
                if (num[ind] <= target) {
                    taken = dp[ind - 1][target - num[ind]];
                }

                dp[ind][target] = (notTaken + taken)%1000000007;
            }
        }

        return dp[n - 1][k];
    }

}
