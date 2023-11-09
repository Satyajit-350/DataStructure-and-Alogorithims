package string;

import java.util.*;

/**
 * Given a string s, return the number of homogenous substrings of s. 
 * Since the answer may be too large, return it modulo 109 + 7.
 * A string is homogenous if all the characters of the string are the same.
 * A substring is a contiguous sequence of characters within a string.
 */
public class count_homogenous_substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Answer is: "+ countHomogenous(str));
    }
    public static int countHomogenous(String s) {
        
        int count = 0;
        long ans = 0;
        int ch = ' ';
        for(int c: s.toCharArray()){
            if(c==ch){
                count++;
                ans += count;
            }else{
                count = 1;
                ans++;
                ch = c;
            }
        }
        return (int)(ans%1000000007);
    }
}
