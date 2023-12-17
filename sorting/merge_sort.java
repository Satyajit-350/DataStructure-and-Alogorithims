package sorting;

import java.util.Scanner;

public class merge_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, n-1);
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void mergeSort(int[] arr, int lb, int ub) {
        if(lb<ub){
            int mid = lb + (ub-lb)/2;
            mergeSort(arr, lb, mid);
            mergeSort(arr, mid+1, ub);
            merge(arr,lb, mid,ub);
        }
    }

    private static void merge(int[] arr, int lb, int mid, int ub) {
        int ans[] = new int[ub-lb+1];
        int i = lb; 
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=ub){
            if(arr[i] < arr[j]){
                ans[k] = arr[i];
                i++;
            }else{
                ans[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            ans[k] = arr[i];
            i++;
            k++;
        }
        while(j<=ub){
            ans[k] = arr[j];
            j++;
            k++;
        }
        for(i=lb; i<=ub; i++){
            arr[i] = ans[i-lb];
        }
    }
}
