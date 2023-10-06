package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class modified_numbers_and_queries {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int l = Integer.parseInt(input[0]); 
            int r = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.sumOfAll(l,r));
        }
    }
    
}

class Solution
{
    public int sumOfAll(int l, int r)
    {
        // code here
        int ans = 0;
        for(int i=l; i<=r; i++){
            if(i==1){
                ans+=i;
            }else{
                ans += findFactors(i);
            }
            
        }
        return ans;
    }
    public int findFactors(int n){
        int sum = 0;
        boolean prime[] = new boolean[n+1];
        for(int i=1; i<=n; i++){
            //make all the number as prime
            prime[i] = true;
        }
        for(int i=2; i<=n; i++){
            if(prime[i]&&n%i==0){
                sum+=i;
            }
            for(int j=2*i; j<=n; j=j+i){
                prime[j] = false;
            }
        }
        System.out.println(sum);
        return sum;
    }
}