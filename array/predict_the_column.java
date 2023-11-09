package array;

import java.util.*;

public class predict_the_column {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Answer is: "+ columnWithMaxZeros(arr, n));
    }
    public static int columnWithMaxZeros(int arr[][], int N) {
        /*Brute force approach*/
        // Map<Integer, Integer> hm = new HashMap<>();
        // for(int i=0; i<N; i++){
        //     for(int j=0; j<N; j++){
        //         if(arr[i][j]==0){
        //             hm.put(j,hm.getOrDefault(j,0)+1);
        //         }
        //     }
        // }
        // int max = Integer.MIN_VALUE;
        // int ans = -1;
        // for(Map.Entry<Integer, Integer> map: hm.entrySet()){
        //     // System.out.println(map.getKey() + " - "+ map.getValue());
        //     if(map.getValue()>max){
        //         ans = map.getKey();
        //         max = map.getValue();
        //     }
        // }
        // return ans;
        
        /* Oprimal Approach */
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            int count = 0;
            for(int j=0; j<N; j++){
                if(arr[j][i] == 0){
                    count++;
                }
            }
            if(count>max){
                max = count;
                ans = i;
                //edge case
                if(max==N){
                    break;
                }
            }
        }
        if(max==0){
            return -1;
        }
        return ans;
    }
}
