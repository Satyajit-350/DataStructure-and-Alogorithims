package string;

import java.io.*;
import java.util.*;

public class maximum_substring {

    public static void main(String args[])throws IOException
        {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            while(t-- > 0)
            {
                String w = read.readLine();
                int n = Integer.parseInt(read.readLine());
                String TE[] = read.readLine().trim().split(" ");
                char x[] = new char[n];
                for(int i = 0;i<n;i++)
                {
                    x[i] = TE[i].charAt(0);
                }
                
                String TR[] = read.readLine().trim().split(" ");
                int b[] = new int[n];
                for(int i = 0;i<n;i++)
                {
                    b[i] = Integer.parseInt(TR[i]);
                }
               
                Solution ob = new Solution();
                System.out.println(ob.maxSum(w,x,b,n));
            }
        }
}
                             
class Solution{
    static String maxSum(String w,char x[],int b[], int n){
        //code here
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<w.length(); i++){
            int X = w.charAt(i);
            arr.add(X);
        }
        for(int i=0; i<arr.size(); i++){
            for(int j=0; j<n; j++){
                if(x[j]==arr.get(i)){
                    arr.set(i,b[j]);
                }
            }
            System.out.print(arr.get(i)+" ");
        }

        

        return "yes";
    }
}
    
