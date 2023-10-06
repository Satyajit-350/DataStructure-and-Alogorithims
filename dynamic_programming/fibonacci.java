package dynamic_programming;
import java.util.*;

public class fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = fun(n);
        System.out.println("Recursion: " + ans);


        //memoization
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        ans = fun2(n,dp);
        System.out.println("Memoization: " + ans);


        //tabulation
        int dp2[] = new int[n+1];
        Arrays.fill(dp2,-1);
        ans = fun3(n, dp2);
        System.out.println("Tabulation: " + ans);
    }
    private static int fun(int n){
        if(n<=1){
            return n;
        }
        return fun(n-1)+fun(n-2);
    }
    private static int fun2(int n, int dp[]){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n] = fun2(n-1,dp)+fun2(n-2,dp);
    }
    private static int fun3(int n, int dp[]){
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
