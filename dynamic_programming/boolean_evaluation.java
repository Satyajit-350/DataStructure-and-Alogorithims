package dynamic_programming;

import java.util.*;

public class boolean_evaluation {

    public static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("Answer is: " + evaluateExp(str));
    }
    public static int evaluateExp(String exp) {
        // Write your code here.
        int n = exp.length();
        long dp[][][] = new long[n][n][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<2; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        // return (int)solve(0,exp.length()-1,1, exp);
        return (int)solveUsingMemoization(exp,0,exp.length()-1,1, dp);
    }
    //Recursive
    public static long solve(int i, int j, int isTrue, String exp){
        //base case
        if(i>j){
            return 0;
        }
        if(i==j){
            if (isTrue == 1) {
                return exp.charAt(i) == 'T' ? 1 : 0;
            } else {
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }
        long ways = 0;
        for(int ind=i+1; ind<=j-1; ind+=2){
            long lT = solve(i, ind - 1, 1, exp);
            long lF = solve(i, ind - 1, 0, exp);
            long rT = solve(ind + 1, j, 1, exp);
            long rF = solve(ind + 1, j, 0, exp);

            char operator = exp.charAt(ind);
            if (operator == '&') {
                if (isTrue == 1) {
                    ways = (ways + (lT * rT) % MOD) % MOD;
                } else {
                    ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lF * rF) % MOD) % MOD;
                }
            } else if (operator == '|') {
                if (isTrue == 1) {
                    ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lT * rT) % MOD) % MOD;
                } else {
                    ways = (ways + (lF * rF) % MOD) % MOD;
                }
            } else {
                if (isTrue == 1) {
                    ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD) % MOD;
                } else {
                    ways = (ways + (lF * rF) % MOD + (lT * rT) % MOD) % MOD;
                }
            }
        }
        return ways;
    }
    //Memoization
    public static long solveUsingMemoization(String exp, int i, int j, int isTrue, long[][][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue == 1) {
                return exp.charAt(i) == 'T' ? 1 : 0;
            } else {
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }
        
        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }

        long ways = 0;
        for (int ind = i + 1; ind <= j - 1; ind += 2) {
            long lT = solveUsingMemoization(exp, i, ind - 1, 1, dp);
            long lF = solveUsingMemoization(exp, i, ind - 1, 0, dp);
            long rT = solveUsingMemoization(exp, ind + 1, j, 1, dp);
            long rF = solveUsingMemoization(exp, ind + 1, j, 0, dp);

            char operator = exp.charAt(ind);
            if (operator == '&') {
                if (isTrue == 1) {
                    ways = (ways + (lT * rT) % MOD) % MOD;
                } else {
                    ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lF * rF) % MOD) % MOD;
                }
            } else if (operator == '|') {
                if (isTrue == 1) {
                    ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lT * rT) % MOD) % MOD;
                } else {
                    ways = (ways + (lF * rF) % MOD) % MOD;
                }
            } else {
                if (isTrue == 1) {
                    ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD) % MOD;
                } else {
                    ways = (ways + (lF * rF) % MOD + (lT * rT) % MOD) % MOD;
                }
            }
        }

        return dp[i][j][isTrue] = ways;
    }
}
