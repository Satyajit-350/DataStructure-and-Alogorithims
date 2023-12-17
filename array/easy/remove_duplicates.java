package array.easy;

import java.util.HashSet;
import java.util.Scanner;

public class remove_duplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Answer is: " + removeDuplicates(arr, n));
    }

    public static int removeDuplicates(int arr[],int n) {
		// Write your code here. 
		HashSet<Integer> hs = new HashSet<>();
		for(int e: arr){
			hs.add(e);
		}
		return hs.size();
	}
}
