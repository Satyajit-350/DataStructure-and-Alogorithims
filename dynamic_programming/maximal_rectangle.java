package dynamic_programming;

import java.util.*;

public class maximal_rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char arr[][] = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println("Answer is: " + maximalRectangle(arr));
    }
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int height[] = new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                }else{
                    height[j] = 0;
                }
            }
            int area = largestRectangleInHistogram(height);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public static int largestRectangleInHistogram(int histo[]){
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int n = histo.length;
        for(int i=0; i<=n; i++){
            while(!st.isEmpty() && (i==n||histo[st.peek()]>=histo[i])){
                int height = histo[st.pop()];
                int width = 0;
                if(st.isEmpty()){
                    width = i;
                }else{
                    width = i-st.peek()-1;
                }
                max = Math.max(max, width*height);
            }
            st.push(i);
        }
        return max;
    }
}
