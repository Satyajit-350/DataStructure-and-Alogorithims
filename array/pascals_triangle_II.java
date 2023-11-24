package array;

import java.util.*;

/**
 * This program is to get a particular row in a pascal traingle
 */
public class pascals_triangle_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        System.out.println(getRow(row));
    }
    public static List<Integer> getRow(int n) {
        List<Integer> ans = new ArrayList<>();
        int prev[] = new int[n+1];
        int count = 1;
        prev[count] = 1;
        while(count<=n){
            count++;
            int curr[] = new int[n+1];
            for(int i=1; i<count; i++){
                curr[i] = (prev[i-1]+prev[i]);
            }
            prev = curr;
        }
        for(int i=1; i<prev.length; i++){
            ans.add(prev[i]);
        }
        return ans;
    }
}
