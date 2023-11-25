package array;

import java.util.*;

public class supermarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int cBag[][] =new int[n][2];
        for(int i=0; i<n; i++){
            cBag[i][0] = sc.nextInt();
            cBag[i][1] = sc.nextInt();
        }

        int rBag[][] = new int[m][2];
        for(int i=0; i<m; i++){
            rBag[i][0] = sc.nextInt();
            rBag[i][1] = sc.nextInt();
        }

        System.out.println(solve(n,m,cBag,rBag));
    }

    private static int solve(int n, int m, int[][] cBag, int[][] rBag) {
        int count = 0;

        for (int[] customer : cBag) {
            for (int[] bag : rBag) {
                if (bag[0] >= customer[0] && bag[1] <= customer[1]) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
