package dynamic_programming;

import java.util.*;

public class shortest_common_subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println("Answer is: " + shortestSupersequence(str1, str2));
    }
    public static String shortestSupersequence(String a, String b) {
        // Write your code here..
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n+1][m+1];
        for(int arr[]: dp){
            Arrays.fill(arr,-1);
        }
        return solveUsingTabulation(n, m, a, b, dp);
    }
    public static String solveUsingTabulation(int n, int m, String s, String t, int dp[][]){
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
                }	
            }
        }
        int i = n;
        int j= m;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(s.charAt(i-1)==t.charAt(j-1)){
                //match case
                sb.append(s.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                sb.append(s.charAt(i-1));
                i--;
            }else{
                sb.append(t.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            sb.append(s.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(t.charAt(j-1));
            j--;
        }
        // System.out.println(sb.reverse().toString());
        return sb.reverse().toString();
    }
}
