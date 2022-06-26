package recursion;

import java.util.Scanner;

public class insertionSortRecusive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sortArray(arr,1,n);
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
        int temp = arr[i];
        int k = i-1;
        while(k>=0&&arr[k]>temp){
            arr[k+1] = arr[k];
            k--;
        }
        arr[k+1] = temp;

        //recursion
        sortArray(arr, i+1, n);
    }

    
}
