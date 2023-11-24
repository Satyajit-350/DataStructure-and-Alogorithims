package array;

import java.util.*;

/**
 * This program is to genetate the pascals triangle
 */
public class pascals_traingle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(generate(n));
    }
    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, prev = null;

        for(int i=0; i<n; i++){
            //we know for each row the number of coloumns are same i.e.
            //if we are in row 5 then number of coloumn is 5
            row = new ArrayList<>();
            for(int j=0; j<=i; j++){
                //check if it is the first element or last element
                if(j==0||j==i){
                    row.add(1);
                }else{
                    row.add(prev.get(j-1)+prev.get(j));
                }
            }
            prev = row;
            res.add(row);
        }
        return res;
    }
}
