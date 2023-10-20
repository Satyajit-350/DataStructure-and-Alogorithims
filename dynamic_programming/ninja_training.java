package dynamic_programming;

import java.util.*;

public class ninja_training {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int points[][] = new int[n][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){
                points[i][j] = sc.nextInt();
            }
        }
        System.out.println("Answer is: "+ ninjaTraining(n, points));
    }

    public static int ninjaTraining(int n, int points[][]) {

        // return solve(n-1,3,points);
        int dp[][] = new int[n][4];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        // return solveUsingMemoization(n-1,3,points, dp);
        return solveUsingTabulation(n,points,dp);
       
    }
    //recursive
    public static int solve(int day, int last, int points[][]){
        //base case
        if(day==0){
            int max = 0;
            for(int i=0; i<3; i++){
                if(i!=last){
                    max = Math.max(max,points[day][i]);
                }
            }
            return max;
        }
        int max = 0;
        for(int i=0; i<3; i++){
            if(i!=last){
                int point = points[day][i] + solve(day-1, i, points);
                max = Math.max(max,point);
            }
        }
        return max;
    }
    //memoization
    public static int solveUsingMemoization(int day, int last, int points[][],int dp[][]){
        //base case
        if(dp[day][last]!=-1){
            return dp[day][last];
        }
        if(day==0){
            int max = 0;
            for(int i=0; i<3; i++){
                if(i!=last){
                    max = Math.max(max,points[0][i]);
                }
            }
            return dp[day][last] = max;
        }
        
        int max = 0;
        for(int i=0; i<3; i++){
            if(i!=last){
                int point = points[day][i] + solveUsingMemoization(day-1, i, points,dp);
                max = Math.max(max,point);
            }
        }
        return dp[day][last] = max;
    }
    //tabulation
    public static int solveUsingTabulation(int day, int points[][],int dp[][]){
        //base case
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        for(int d=1; d<day; d++){
            for(int l=0; l<4; l++){
                dp[d][l] = 0;
                for(int i=0; i<3; i++){
                    if(i!=l){
                        int point = points[d][i] + dp[d-1][i];
                        dp[d][l] = Math.max(dp[d][l],point);
                    }
                }
            }
        }
        return dp[day-1][3];
    } 

}
