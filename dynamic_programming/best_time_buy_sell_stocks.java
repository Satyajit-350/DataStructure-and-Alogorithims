package dynamic_programming;

import java.util.*;

public class best_time_buy_sell_stocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + maximumProfit(arr));
    }
    public static int maximumProfit(int[] prices){
        // Write your code here. 
        int min = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            int cost = prices[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
