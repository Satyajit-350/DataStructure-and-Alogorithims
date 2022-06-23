package recursion;

import java.util.Scanner;

public class powerTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n =sc.nextInt();
        int ans = power(n);
        System.out.println("Power of two is: "+ans);
    }

    private static int power(int n) {
        //base case
        if(n==0){
            return 1;
        }
        return 2*power(n-1);
    }
}
