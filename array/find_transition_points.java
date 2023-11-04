package array;

import java.util.*;

public class find_transition_points {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n]; //the array contains only 0's and 1's and must ne sorted
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + transitionPoint(arr, n));
    }

    public static int transitionPoint(int arr[], int n) {
        // code here 
        //optimal
        int res = -1;
        int lb = 0;
        int ub = n-1;
        while(lb<=ub){
            int mid = lb + (ub-lb)/2;
            if(arr[mid] == 1){
                res =  mid;
                ub = mid -1;
            }else {
                lb = mid+1;
            }
        }
        return res;
    }
}
