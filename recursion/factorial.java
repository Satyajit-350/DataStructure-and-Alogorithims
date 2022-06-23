package recursion;

import java.util.Scanner;

public class factorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        int ans = fact(n);
        System.out.println("Factorial of a number is: "+ans);
    }

    private static int fact(int n) {
        //base case
        if(n==0){
            return 1;
        }
        return n * fact(n-1);
    }
    
}
