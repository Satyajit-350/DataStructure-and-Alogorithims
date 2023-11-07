package array;

import java.util.*;
import java.util.ArrayList;

public class sum_upper_lower_matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int mat[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        ArrayList<Integer> ans = sumTriangles(mat, n);
        for(int e: ans){
            System.out.println(e);
        }
    }

    static ArrayList<Integer> sumTriangles(int matrix[][], int n){
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();
        int uSum = 0, lSum = 0;
        //upper sum
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                uSum += matrix[i][j];
            }
        }
        ans.add(uSum);

        //lower sum which gives TLE
        // for(int i=n-1; i>=0; i--){
        //     for(int j=i; j>=0; j--){
        //         lSum += matrix[i][j];
        //     }
        // }

        //lower sum
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                lSum += matrix[i][j];
            }
        }
        ans.add(lSum);
        return ans;
    }
    
}
