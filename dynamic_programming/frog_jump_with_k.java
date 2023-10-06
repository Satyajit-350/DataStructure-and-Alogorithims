package dynamic_programming;

import java.util.*;

public class frog_jump_with_k {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int height[] = new int[n];
        for(int i=0; i<n; i++){
            height[i] = sc.nextInt();
        }
        int ans = frogJump2(n, k, height);
        System.out.println("Answer is: "+ ans);
    }

    public static int frogJump2(int n, int k, int []height){
        // Write your code here. 
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return solve2(n-1,k, height,dp);
    }
    public static int solve(int idx, int k, int height[],int dp[]){
        //base case 
        if(idx==0){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans = Integer.MAX_VALUE;
        for(int j=1; j<=k; j++){
            if(idx-j >= 0){
                int fs = solve(idx-j, k, height,dp) + Math.abs(height[idx] - height[idx-j]);
                ans = Math.min(fs, ans);
            }
        }
        return dp[idx] = ans;
        
    }
    public static int solve2(int idx, int k, int height[],int dp[]){
        //base case 
        dp[0] = 0;
        for(int i=1; i<=idx; i++){
            int ans = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(i-j >= 0){
                    int fs = dp[i-j] + Math.abs(height[i] - height[i-j]);
                    ans = Math.min(fs, ans);
                }
            }
            dp[i] = ans;
        }
        
        return dp[idx];
        
    }

}
