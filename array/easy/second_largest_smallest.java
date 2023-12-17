package array.easy;

import java.util.*;

public class second_largest_smallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans[] =  getSecondOrderElements(n, arr);
        System.out.println("Answer is : " + ans[0] + " " + ans[1]);
    }

    public static int[] getSecondOrderElements(int n, int []arr) {
        // Write your code here.
        Arrays.sort(arr);
        int ans[] = new int[2];
        ans[0] = arr[n-2];
        ans[1] = arr[1];
        return ans;
    }
}
