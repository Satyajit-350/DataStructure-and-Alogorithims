package array;

import java.util.*;

public class diagonal_traverse_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> ls = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int m = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            for(int j=0; j<m; j++){
                arr.add(sc.nextInt());
            }
            ls.add(arr);
        }
        int ans[] = findDiagonalOrder(ls);
        for(int e: ans){
            System.out.print(e + " ");
        }
        System.out.println();
    }
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        int size = nums.size();
        int count = 0;
        for(int i=0; i<size; i++){
            for(int j=0; j<nums.get(i).size(); j++){
                int key = i + j;
                int value = nums.get(i).get(j);
                if(!hm.containsKey(key)){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(value);
                    hm.put(key,ls);
                }else{
                    List<Integer> ls = hm.get(key);
                    ls.add(value);
                    hm.put(key,ls);
                }
                count++;
            }
        }
        int ans[]=new int[count];
        int i=0,num=0;
        while(hm.containsKey(num)){
            List<Integer> ls = hm.get(num);
            Collections.reverse(ls);
            for(int k:ls){
                ans[i++]=k;
            }
            num++;
        }
        return ans;
    }
}
