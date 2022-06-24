package recursion;

import java.util.Scanner;

public class power {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans = findPow(a,b);
        System.out.println("Power is : "+ ans);
    }

    private static int findPow(int a, int b) {
        //base case
        if(b==0){
            return 1;
        }
        if(b==1){
            return a;
        }
        int ans = findPow(a, b/2);
        if(b%2==0){
            return ans*ans;
        }else{
            return a*(ans*ans);
        }
    }
    
}
