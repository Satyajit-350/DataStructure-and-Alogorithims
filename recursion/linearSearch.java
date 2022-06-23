package recursion;

public class linearSearch {
    public static void main(String[] args) {
        int arr[] = new int[]{5,1,2,3,6,9};
        boolean ans = search(arr,6,10);
        if(ans){
            System.out.println("Element found.");
        }else{
            System.out.println("Element not found");
        }
        
    }

    private static boolean search(int[] arr, int n, int key) {
        //base case
        if(n==0){
            return false;
        }
        if(arr[n-1]==key){
            return true;
        }else{
            return search(arr,n-1,key);
        }
    }
    
}
