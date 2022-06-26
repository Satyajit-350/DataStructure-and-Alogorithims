package recursion;

import java.util.*;

public class subset {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> res = new ArrayList<>();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        res = subsets(arr);
        if(!res.isEmpty()){
            for(int i = 0; i<res.size(); i++){
                System.out.print(res.get(i)+" ");
            }
        }
        
    }

    private static List<List<Integer>> subsets(int[] arr) {
        if(arr.length==0){
            return new ArrayList<>();
        }
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int i=0;
        solve(arr,i,ans,output);
        return output;
    }

    private static void solve(int[] arr, int i, List<Integer> ans, List<List<Integer>> output) {
        //base case
        if(i>=arr.length){
            output.add(new ArrayList<>(ans));
            return;
        }

        //include
        int ele = arr[i];
        ans.add(ele);
        solve(arr,i+1,ans,output);

        //exclude
        ans.remove(ans.size()-1);
        solve(arr,i+1,ans,output);
    }
    
}
