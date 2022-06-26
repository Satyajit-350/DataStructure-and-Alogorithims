package recursion;

import java.util.Scanner;

public class selectionSortRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sortArray(arr,0,n);
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    private static void sortArray(int[] arr, int i, int n) {
        //base case
        if(i==n){
            return;
        }

        //condition
        int pos = minimum(arr,i,n-1);
        swap(arr,i,pos);


        //recursion
        sortArray(arr, i+1, n);
    }

    private static void swap(int[] arr, int i, int pos) {
        int temp =arr[i];
        arr[i] = arr[pos];
        arr[pos] = temp;
    }

    //recursive function to find miminum element from the array
    private static int minimum(int[] arr, int i, int j) {
        
        //base case...only one element present
        if(i==j){
            return i;
        }

        //head recursion
        int k = minimum(arr, i+1, j);

        //condition
        if(arr[i]<arr[k]){
            return i;
        }else{
            return k;
        }
    }
}
