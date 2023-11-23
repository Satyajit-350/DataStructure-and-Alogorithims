package string;

import java.util.*;

public class lisence_key_formatting {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = sc.next();
        int k =sc.nextInt();
        System.out.println("Answer is: " + licenseKeyFormatting(str, k));
    }
    public static String licenseKeyFormatting(String s, int k) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)!='-'){
                count++;
                sb.insert(0, Character.toUpperCase(s.charAt(i)));
                if(count==k){
                    sb.insert(0,"-");
                    count = 0;
                }
            }
        }
        if(count==0 && sb.length()>=1){
            return sb.toString().substring(1);
        }
        return sb.toString();
    }
}
