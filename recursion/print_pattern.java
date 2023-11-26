package recursion;

import java.util.*;

/* 
   Print a sequence of numbers starting with N, without using loop, 
   where replace N with N - 5, until N > 0. After that replace N with N + 5 until N 
   regains its initial value.

 */

public class print_pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(pattern(n));
    }

    public static List<Integer> pattern(int N){
        // code here
        List<Integer> ans = new ArrayList<>();
        // int temp = N;
        // while(temp>0){
        //     ans.add(temp);
        //     temp -= 5;
        // }
        
        // while(temp!=N){
        //     ans.add(temp);
        //     temp += 5;
        // }
        // ans.add(temp);
        // return ans;
        
        //without using loop - Recursion :)
        solve(N, N, ans);
        
        return ans;
    }
    public static void solve(int n, int temp, List<Integer> ans){
        //first add the number 
        ans.add(temp);
        //base case
        if(temp<=0){
            return;
        }
        solve(n, temp-5, ans);
        //add the element while backtracking
        ans.add(temp);
    }

}
