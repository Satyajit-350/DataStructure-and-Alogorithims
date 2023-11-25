package array;

import java.util.*;

public class vip_cafe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(solve(n, k, arr));
    }
    public static int solve(int n, int k, int arr[]){

        int max = -1;
        int count = 0;
        while(true){
            int prev = 0;
            max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                if(max == arr[i]){
                    continue;
                }
                if(arr[i]>max){
                    max = arr[i];
                    prev = i;
                }
            }
            
            // System.out.println("maximum: " + max + " prev idx: " + prev);
            arr[prev] = -1;
            for(int j=prev-1; j>=0; j--){
                if(arr[j]!=-1){
                    arr[j] += 1;
                }
            }
            // for(int e: arr){
            //     System.out.print(e + " ");
            // }
            // System.out.println();
            count++;
            if(prev+1==k){
                break;
            }
        }

        return count;
    }
}
