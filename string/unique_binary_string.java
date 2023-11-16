package string;

import java.util.*;

/* 
    Given an array of strings nums containing n unique binary strings each of length n, 
    return a binary string of length n that does not appear in nums.
    If there are multiple answers, you may return any of them.
 */

public class unique_binary_string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String nums[] = new String[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.next();
        }
        System.out.println("Answer is: " + findDifferentBinaryString(nums));
    }
    public static String findDifferentBinaryString(String[] nums) {
        String ans = "";
        for(int i=0; i<nums.length; i++){
            if(nums[i].charAt(i)=='1'){
                ans += '0';
            }else{
                ans += '1';
            }
        }
        return ans;
    }
}
