package dynamic_programming;

import java.util.*;

public class frog_jump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int height[] = new int[n];
        for(int i=0; i<n; i++){
            height[i] = sc.nextInt();
        }
        int ans = frogJump(n, height);
        System.out.println("Answer is: "+ ans);
    }

    public static int frogJump(int n, int heights[]) {

        // Write your code here.. 
        //memoization
        // int dp[] = new int[n+1];
        // Arrays.fill(dp, -1);
        // // return fun(n-1, heights, dp);


        // //tabulation
        // return fun2(n-1,heights,dp);

        int prev = 0;
        int prev2 = 0;
        int ss = Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            int fs = prev + Math.abs(heights[i] - heights[i-1]);
            if(i>1){
                ss = prev2 + Math.abs(heights[i] - heights[i-2]);
            }
            int curr = Math.min(fs,ss);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public static int fun(int idx, int height[], int dp[]){
        //base case
        if(idx==0){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int left = fun(idx-1,height,dp) + Math.abs(height[idx]- height[idx-1]);
        int right = Integer.MAX_VALUE;
        if(idx>1){
            right = fun(idx-2,height,dp) + Math.abs(height[idx] - height[idx-2]);
        }
        return dp[idx] = Math.min(left,right);
    }
    public static int fun2(int idx, int height[], int dp[]){
        //base case
        dp[0] = 0;
        int right = Integer.MAX_VALUE;
        for(int i=1; i<=idx; i++){
            int left = dp[i-1] + Math.abs(height[i] - height[i-1]);
            if(i>1){
                right = dp[i-2] + Math.abs(height[i] - height[i-2]);
            }
            dp[i] = Math.min(left,right);
        }
        return dp[idx];
    }

}
