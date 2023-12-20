package dynamic_programming;

import java.util.*;

public class count_number_of_square_submatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Answer is: " + countSquares(arr));
    }
    public static int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for(int i=0; i<n; i++){
            dp[i][0] = matrix[i][0];
        }
        for(int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j]==1){
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int sum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sum += dp[i][j];
            }
        }
        return sum;
    }
}
