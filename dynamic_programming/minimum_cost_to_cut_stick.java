package dynamic_programming;

import java.util.*;

public class minimum_cost_to_cut_stick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int arr[] = new int[c];
        for(int i=0; i<c; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + cost(n, c, arr));
    }   
    public static int cost(int n, int c, int cuts[]) {

        // Write your code here.. 
        List<Integer> list = new ArrayList<>();
        for(int e: cuts){
            list.add(e);
        }
        int dp[][] = new int[c+2][c+2];
        // for(int a[]: dp){
        //     Arrays.fill(a,-1);
        // }
        list.add(0);
        list.add(n);
        Collections.sort(list);
        // return solve(1, c, list);
        // return solveUsingMemoization(1,c,list,dp);
        return solveUsingTabulation(n, c, list, dp);
    }
    //Recursive
    public static int solve(int i, int j, List<Integer> cuts){
        //base case
        if(i>j){
            return 0;
        }
        int min = (int)(1e9);
        for(int idx=i; idx<=j; idx++){
            int cost = cuts.get(j+1) - cuts.get(i-1) + solve(i, idx-1, cuts) + solve(idx+1, j, cuts);
            min = Math.min(min,cost);
        }
        return min;
    }
    //Memoization
    public static int solveUsingMemoization(int i, int j, List<Integer> cuts, int dp[][]){
        //base case
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min = (int)(1e9);
        for(int idx=i; idx<=j; idx++){
            int cost = cuts.get(j+1) - cuts.get(i-1) + solveUsingMemoization(i, idx-1, cuts, dp) + solveUsingMemoization(idx+1, j, cuts, dp);
            min = Math.min(min,cost);
        }
        return dp[i][j] = min;
    }
    //Tabulation
    public static int solveUsingTabulation(int n, int c, List<Integer> cuts, int dp[][]){
        for(int i=c; i>=1; i--){
            for(int j=1; j<=c; j++){
                if(i>j) continue;
                int min = (int)(1e9);
                for(int idx=i; idx<=j; idx++){
                    int cost = cuts.get(j+1) - cuts.get(i-1) + dp[i][idx-1] + dp[idx+1][j];
                    min = Math.min(min,cost);
                }
                dp[i][j] = min; 
            }
        }
        return dp[1][c];
    }
}
