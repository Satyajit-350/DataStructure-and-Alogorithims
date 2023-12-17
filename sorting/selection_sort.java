package sorting;

import java.util.Scanner;

public class selection_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        selectionSort(arr, n);
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int arr[], int n){
        for(int i=1; i<n; i++){
            int pos = minPosition(arr, i-1, n-1);
            //swap
            int temp = arr[i-1];
            arr[i-1] = arr[pos];
            arr[pos] = temp;
        }
    }

    private static int minPosition(int[] arr, int lb, int ub) {
        int min = arr[lb];
        int pos = lb;
        for(int i= lb+1; i<=ub; i++){
            if(arr[i]<min){
                min = arr[i];
                pos = i;
            }
        }
        return pos;
    }
}
