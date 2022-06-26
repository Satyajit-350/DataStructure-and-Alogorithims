package recursion;

import java.util.Scanner;

public class quickSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sort(arr,0,n-1);
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    private static void sort(int[] arr, int lb, int ub) {
        if(lb>=ub){
            return;
        }
        int p = partition(arr,lb,ub);
        sort(arr,lb,p-1);
        sort(arr,p+1,ub);
    }

    private static int partition(int[] arr, int lb, int ub) {
        int pivot = arr[lb];
        int i = lb;
        int j = ub;
        while(i<j){
            while(i<j&&arr[i]<=pivot){
                i++;
            }
            while(arr[j]>pivot){
                j--;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,lb,j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
