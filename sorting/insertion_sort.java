package sorting;

import java.util.Scanner;

public class insertion_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        insertionSort(arr, n);
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void insertionSort(int[] arr, int n) {
        for(int i=0; i<n; i++){
            int temp = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                 j--;
            }
            arr[j+1] = temp;
        }
    }
}
