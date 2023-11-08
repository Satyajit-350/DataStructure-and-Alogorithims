package dynamic_programming;

import java.util.*;

/**
 * This question is exact the same question i.e., Count partition with given difference 
 */
public class target_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println("Answer is: "+ targetSum(n, target, arr));
    }
    public static int targetSum(int n, int target, int[] arr) {
    	// Write your code here. 
        return countPartitions(n, target, arr);
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
		// return solveUsingMemoization(n-1, tar, arr, dp);
        return solveUsingTabulation(tar, n, arr, dp);
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
        return (take+ nottake);
    }
    //Memoization
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
        return dp[idx][target] = (take+ nottake);
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
            for (int target = 0; target <= k; target++) {
                int notTaken = dp[ind - 1][target];

                int taken = 0;
                if (num[ind] <= target) {
                    taken = dp[ind - 1][target - num[ind]];
                }

                dp[ind][target] = (notTaken + taken);
            }
        }

        return dp[n - 1][k];
    }
}
