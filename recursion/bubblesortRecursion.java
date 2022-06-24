package recursion;

import java.util.Scanner;

public class bubblesortRecursion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sortArray(arr,n);
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    private static void sortArray(int[] arr, int n) {
        if(n==0||n==1){
            return;
        }
        for(int i=0; i<n-1; i++){
            if(arr[i]>arr[i+1]){
                swap(arr,i,i+1);
            }
        }
        sortArray(arr,n-1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
