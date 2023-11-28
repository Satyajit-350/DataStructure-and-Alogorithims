package dynamic_programming;

import java.util.*;

public class longest_increasing_chain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str[] = new String[n];
        for(int i=0; i<n; i++){
            str[i] = sc.next();
        }
        System.out.println("Answer is: " + longestStrChain(str));
    }
    public static int longestStrChain(String[] arr) {
        // Write your code here. 
        Arrays.sort(arr, (a, b)->Integer.compare(a.length(), b.length()));
        int n = arr.length;
        int dp[] = new int[n];
	    Arrays.fill(dp,1);
	    int max = 1;
	    for(int idx=0; idx<n; idx++){
	        for(int prev=0; prev<=idx-1; prev++){
	            if(compareString(arr[idx], arr[prev]) && (1 + dp[prev]) > dp[idx]){
	                dp[idx] = 1 + dp[prev];
	            }
                if(dp[idx]>max){
                    max = dp[idx];
                }
	        }
	    }
        return max;
    }
    public static boolean compareString(String s1, String s2){
        if(s1.length() != s2.length()+1){
            return false;
        }
        int i = 0;
        int j = 0;
        while(i<s1.length()){
            if(j<s2.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        if(i==s1.length() && j==s2.length()){
            return true;
        }
        return false;
    }
}
