package recursion;

public class pallindromeString {

    public static void main(String[] args) {
        String s = "abbac";
        int lb = 0;
        int ub = s.length()-1;
        boolean ans = checkPallindrome(s,lb,ub);
        if(ans){
            System.out.println("pallindrome");
        }else{
            System.out.println("Not pallindrome");
        }
    }

    private static boolean checkPallindrome(String s, int lb, int ub) {
        //base case
        if(lb>ub){
            return true;
        }
        if(s.charAt(lb)!=s.charAt(ub)){
            return false;
        }else{
            //recursion
            lb++;
            ub--;
            return checkPallindrome(s, lb, ub);
        }
    }
}
