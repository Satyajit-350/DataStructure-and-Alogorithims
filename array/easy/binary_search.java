package array.easy;

import java.util.*;

public class binary_search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Element found at index: " + binarySearch(arr, n, num));
    }
    public static int binarySearch(int arr[], int n, int num){
        int lb = 0;
        int ub = n-1;
        while(lb<=ub){
            int mid = lb + (ub-lb)/2;
            System.out.println(mid);
            if(arr[mid] == num){
                return mid;
            }else{
                if(arr[mid]>num){
                    ub = mid-1;
                }else{
                    lb = mid+1;
                }
            }
        }
        return -1;
    }
}
