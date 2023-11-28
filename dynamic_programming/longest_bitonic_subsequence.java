package dynamic_programming;

import java.util.*;

public class longest_bitonic_subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + longestBitonicSequence(arr, n));
    }
    public static int longestBitonicSequence(int[] arr, int n) {
        // Write your code here. 
        int dp1[] = new int[n];
	    Arrays.fill(dp1,1);
	    for(int idx=0; idx<n; idx++){
	        for(int prev=0; prev<=idx-1; prev++){
	            if(arr[prev] < arr[idx] && (1 + dp1[prev]) > dp1[idx]){
	                dp1[idx] = 1 + dp1[prev];
	            }
	        }
	    }
        int dp2[] = new int[n];
	    Arrays.fill(dp2,1);
	    for(int idx=n-1; idx>=0; idx--){
	        for(int prev=n-1; prev>=idx; prev--){
	            if(arr[prev] < arr[idx] && (1 + dp2[prev]) > dp2[idx]){
	                dp2[idx] = 1 + dp2[prev];
	            }
	        }
	    }
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, dp1[i]+dp2[i]-1);
        }
        return max;
    }
}
