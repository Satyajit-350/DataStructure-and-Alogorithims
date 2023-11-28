package dynamic_programming;

import java.util.*;

public class number_of_longest_inc_subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + findNumberOfLIS(arr));
    }
    public static int findNumberOfLIS(int []arr) {
        // Write your code here. 
        int n = arr.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        int max = 1;
	    Arrays.fill(dp,1);
        Arrays.fill(count,1);
	    for(int idx=0; idx<n; idx++){
	        for(int prev=0; prev<=idx-1; prev++){
	            if(arr[prev] < arr[idx] && (1 + dp[prev]) > dp[idx]){
	                dp[idx] = 1 + dp[prev];
                    count[idx] = count[prev];
	            }else if(arr[prev] < arr[idx] && (1+dp[prev])==dp[idx]){
                    count[idx] += count[prev];
                }
	        }
            max = Math.max(max, dp[idx]);
	    }
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(dp[i] == max){
                cnt += count[i];
            }
        }
        return cnt;
    }
}
