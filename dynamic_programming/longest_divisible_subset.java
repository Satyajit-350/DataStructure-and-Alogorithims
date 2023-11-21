package dynamic_programming;

import java.util.*;

public class longest_divisible_subset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + largestDivisibleSubset(arr));
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length; 
        return solve(n, nums);
    }
    public static List<Integer> solve(int n, int arr[]){
        int dp[] = new int[n];
        int hash[] = new int[n];
	    Arrays.fill(dp,1);
        Arrays.sort(arr);
	    int max = 1;
        int lastIdx = 0;
	    for(int idx=0; idx<n; idx++){
            hash[idx] = idx;
	        for(int prev=0; prev<idx; prev++){
	            if(arr[idx]%arr[prev]==0 && (1 + dp[prev]) > dp[idx]){
	                dp[idx] = 1 + dp[prev];
                    hash[idx] = prev;
	            }
                if(dp[idx]>max){
                    max = dp[idx];
                    lastIdx = idx;
                }
	        }
	    }
	    List<Integer> lis = new ArrayList<>();
        lis.add(arr[lastIdx]);
        while(hash[lastIdx] != lastIdx){
            lastIdx = hash[lastIdx];
            lis.add(arr[lastIdx]);
        }
        return lis;
    }
}
