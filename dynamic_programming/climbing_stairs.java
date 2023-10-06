package dynamic_programming;

import java.util.*;

public class climbing_stairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int ans = countDistinctWayToClimbStair(n);
        System.out.println("Answer is: "+ans);
    }

    public static int countDistinctWayToClimbStair(long n) {
		// Write your code here.
		long dp[] = new long[(int)(n+1)];
		Arrays.fill(dp, -1);
        return (int)solve(n,dp);
	}
	public static long solve(long idx,long dp[]){
        //base case
        if(idx<=1){
            return 1;
        }
        // if(dp[(int)idx]!=-1){
		// 	return dp[(int)idx];
		// }
        // //one step down as we are approaching top down which means we took 1 step
        // long left = solve(idx-1,dp);
        // //similarly for 2 steps
        // long right = solve(idx-2,dp);
        // //queston given count all possibe ways
        // return dp[(int)idx] = (left+right)%1000000007;
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=idx; i++){
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        return dp[(int)idx];
    }
}
