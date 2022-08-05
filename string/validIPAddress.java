package string;

import java.util.Scanner;
import java.util.regex.Pattern;

public class validIPAddress {
    public static void main(String[] args) {
        System.out.println("Enter a String : ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(s);
        boolean isValid = isValidIP(s);
        if(isValid){
            System.out.println("valid");
        }else{
            System.out.println("Invalid");
        }
    }

    private static boolean isValidIP(String s) {
        // if(s.length()>15){
        //     return false;
        // }
        // String str[] = s.split("[.]",4);
        // if(str.length!=4){
        //     return false;
        // }
        // for(String e: str){
        //     if(e.length()<=0||e.length()>3){
        //         return false;
        //     }
        //     if(!e.equals("0")&&e.substring(0,1).equals("0")){
        //         return false;
        //     }
        //     try{
        //        int x = Integer.parseInt(e);
        //         if(x<0||x>255){
        //             return false;
        //         } 
        //     }catch(NumberFormatException exception){
        //         return false;
        //     }
            
        // }
        // return true;
    
        boolean ans =Pattern.matches("([0-9]|[1-0][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]\\.){3}[0-9]|[1-0][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]", s);
        return ans;
    }
}
