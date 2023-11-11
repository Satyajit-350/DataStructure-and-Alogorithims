package dynamic_programming;

import java.util.*;

public class print_lcs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println("Answer is: "+ findLCS(s, t));
    }
    public static String findLCS(String s1, String s2){
        // Write your code here.
        int n = s1.length();
		int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int a[]: dp){
            Arrays.fill(a,-1);
        }
        return solveUsingTabulation(n, m, s1, s2, dp);
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
                i = i-1;
            }else{
                j = j-1;
            }
        }
        return sb.reverse().toString();
	}
}
