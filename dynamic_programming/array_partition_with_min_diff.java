package dynamic_programming;

import java.util.*;

/**
 * This question is closely related to Subset Sum Equals k(target)
 */

public class array_partition_with_min_diff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: "+ minSubsetSumDifference(arr, n));
    }
    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here. 
        int totalSum = 0 ;
        for(int e: arr){
            totalSum += e;
        }

        boolean dp[][] = new boolean[n][totalSum+1];
        solveUsingTabulation(n, totalSum, arr, dp);

        //we know the answer is possibe from 0-totalSum
        //dp[n-1][0 ->.....totalSum]
        int min = (int)(1e9);
        for(int i=0; i<=totalSum; i++){
            if(dp[n-1][i]){
                int sum1 = i;
                int sum2 = totalSum - sum1;
                min = Math.min(min, Math.abs(sum1-sum2));
            }
        }
        return min;
    }

    public static void solveUsingTabulation(int n, int k, int a[], boolean dp[][]){
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
    }
}
