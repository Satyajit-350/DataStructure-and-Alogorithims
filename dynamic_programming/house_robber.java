package dynamic_programming;

import java.util.*;

public class house_robber {
    public static void main(String[] args) {
        //this question is of the topic maximum Non-Adjacent Sum
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = maximumNonAdjacentSum(arr);
        System.out.println("Result is: "+ ans);
    }

    public static int maximumNonAdjacentSum(int[] nums) {
        //recursive method (TLE)
        int n = nums.length;
        // return solve(n-1,nums);

        //memoization
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        // return solve2(n-1,nums,dp);

        //Tabulation
        // return solve3(n-1, nums, dp);

        //space optimization
        return solve4(n-1, nums);
    }

    public static int solve(int idx, int nums[]){
        //base case
        if(idx==0){
            return nums[idx];
        }
        if(idx<0){
            return 0;
        }
        int take = nums[idx] + solve(idx-2, nums); //cant take idx-1 as it will be the adjacent
        int not_take = 0 + solve(idx-1,nums);

        return Math.max(take, not_take);
    }
    
    public static int solve2(int idx, int nums[], int dp[]){
        //base case
        if(idx==0){
            return nums[idx];
        }
        if(idx<0){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int take = nums[idx] + solve2(idx-2, nums,dp); //cant take idx-1 as it will be the adjacent
        int not_take = 0 + solve2(idx-1,nums,dp);

        return dp[idx] = Math.max(take, not_take);
    }
    
    public static int solve3(int idx, int nums[], int dp[]){
        //base case
        dp[0] = nums[0];
        int neg = 0;
        for(int i=1; i<=idx; i++){
            //take case
            int take = nums[i];
            if(i>1){
                take += dp[i-2];
            }else{
                take += neg;
            }
            int not_take = 0 + dp[i-1];
            dp[i] = Math.max(take,not_take);
        }
        return dp[idx];
    }
    
    public static int solve4(int idx, int nums[]){
        //base case
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1; i<=idx; i++){
            //take case
            int take = nums[i];
            if(i>1){
                take += prev2;
            }
            int not_take = 0 + prev;
            int curr = Math.max(take,not_take);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
