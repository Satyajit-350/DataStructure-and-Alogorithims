package dynamic_programming;

import java.util.*;

public class coin_change_2 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int coins[] = new int[n];
       for(int i=0; i<n; i++){
        coins[i] = sc.nextInt();
       }
       int amount = sc.nextInt();
       System.out.println("Answer is: "+ change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
        int n = coins.length;	
        long dp[][] = new long[n][amount+1];
        for(long a[]: dp){
            Arrays.fill(a, -1);
        }
        // return solve(n-1, amount, coins);
        return (int) solveUsingMemoization(n-1, amount, coins, dp);
        // return (int) solveUsingTabulation(n, amount, coins, dp);
    }
    //recursive
	public static long solve(int idx, int tar, int arr[]){
		//base case
		if(idx==0){
			return (tar%arr[0]==0)?1:0;
		}
		long not_take = (long) solve(idx-1, tar, arr);
		long take = 0;
		if(arr[idx]<=tar){
			take = solve(idx, tar-arr[idx], arr);
		}
		return take+not_take;
	}
	//Memoization
	public static long solveUsingMemoization(int idx, int tar, int arr[], long dp[][]){
		//base case
		if(idx==0){
			return (tar%arr[0]==0)?1:0;
		}
		if(dp[idx][tar]!=-1){
			return dp[idx][tar];
		}
		long not_take = (long) solveUsingMemoization(idx-1, tar, arr,dp);
		long take = 0;
		if(arr[idx]<=tar){
			take = solveUsingMemoization(idx, tar-arr[idx], arr, dp);
		}
		return dp[idx][tar] = take+not_take;
	}
	//Tabulation
	public static long solveUsingTabulation(int n, int tar, int arr[], long dp[][]){
		for(int t=0; t<=tar; t++){
			dp[0][t] = (t%arr[0]==0)?1:0;
		}
		for(int idx=1; idx<n; idx++){
			for(int t=0; t<=tar; t++){
				long not_take = dp[idx-1][t];
				long take = 0;
				if(arr[idx]<=t){
					take = dp[idx][t-arr[idx]];
				}
				dp[idx][t] = take+not_take;
			}
		}
		return dp[n-1][tar];
	}

}
