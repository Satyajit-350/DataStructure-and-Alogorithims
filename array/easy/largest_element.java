package array.easy;

import java.util.*;

public class largest_element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + largestElement(arr, n));
    }
    static int largestElement(int[] arr, int n) {
        // Write your code here.
        int max = 0;
        for(int e:arr){
            max = Math.max(max, e);
        }
        return max;
    }
}
