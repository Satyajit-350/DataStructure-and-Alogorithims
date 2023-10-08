package dynamic_programming;

import java.util.*;

public class house_robber2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = rob(arr);
        System.out.println("Result is: "+ ans);

    }
    public static int rob(int[] nums) {
        //question is similar to House Robber 1 but with slight modification
        //the last element is connected to first element kind of circluar array
        
        // here we can't take either of first as well as last element
        //what we can do is take two cases either pass the array excluding the 1st ele or
        //we can pass the array excluding the last element
        //at last we can take mximum of both
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i!=0){
                nums1.add(nums[i]);
            }
            if(i!=n-1){
                nums2.add(nums[i]);
            }
        }
        int ans1 = solve(nums1.size()-1, nums1);
        int ans2 = solve(nums2.size()-1, nums2);
        return Math.max(ans1,ans2);
    }
    //we can take memeoization tablutation but here
    //we will take the space optimization one
    public static int solve(int idx, List<Integer> nums){
        //base case
        int prev = nums.get(0);
        int prev2 = 0;
        for(int i=1; i<=idx; i++){
            //take case
            int take = nums.get(i);
            if(i>1){
                take += prev2;
            }
            int not_take = 0 + prev;
            int curr = Math.max(take,not_take);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
