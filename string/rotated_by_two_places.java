package string;

import java.util.*;

public class rotated_by_two_places {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println("Answer is: " + isRotated(s1, s2));
    }
    public static boolean isRotated(String str1, String str2){
        // Your code here
        if(str1.length() <= 2 || str2.length() <= 2){
            if(str1.equals(str2)){
                return true; 
            }else{
                return false;
            }
        }

        if(str1.length()!=str2.length()){
            return false;
        }
        int n = str1.length();
        str1 = str1.concat(str1);
        
        if(str1.indexOf(str2)==2 || str1.indexOf(str2)==n-2){
            return true;
        }
        return false;
    }
    public static void reverse(char[] str, int st,int en){
        while(st<=en){
            char temp = str[st];
            str[st] = str[en];
            str[en] = temp;
            st++;
            en--;
        }
    }
}
