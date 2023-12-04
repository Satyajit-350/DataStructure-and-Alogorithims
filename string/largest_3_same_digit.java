package string;

import java.util.*;

public class largest_3_same_digit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("Answer is: " + largestGoodInteger(str));
    }
    public static String largestGoodInteger(String num) {
        int i=0;
        int j=1;
        int max = 0;
        String ans = "";
        while(i<num.length() && j<num.length()){
            if(num.charAt(i) == num.charAt(j)){
                j++;
                if(j-i == 3){
                    String str = num.substring(i,j);
                    int k = Character.getNumericValue(str.charAt(0));
                    if(k >= max){
                        max = k;
                        ans = str;
                    }
                    i=j;
                }
            }else{
                j++;
                i = j-1;
            }
        }
        return ans;
    }
}
