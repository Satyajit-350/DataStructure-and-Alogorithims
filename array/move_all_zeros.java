package array;

import java.util.*;

public class move_all_zeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        pushZerosToEnd(arr, n);
        System.out.println("Answer is: ");
        for(int e: arr){
            System.out.print(e+" ");
        }
    }
    public static void pushZerosToEnd(int[] arr, int n) {
        /*
         * Brute force
         */
        // int temp[] = new int[n];
        // int j=0; 
        // for(int e: arr){
        //     if(e!=0){
        //         temp[j++] = e;
        //     }
        // }
        // for(int i=0; i<n; i++){
        //     arr[i] = temp[i];
        // }
        
        /*
         * Optimal
         */
        int j=0; 
        for(int i=0; i<n; i++){
            if(arr[i]!=0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
    }
}
