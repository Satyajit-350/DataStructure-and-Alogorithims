package recursion;

public class sorting {

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6};

        boolean ans = isSorted(arr,6);
        if(ans){
            System.out.println("Array is sorted.");
        }else{
            System.out.println("Array is not sorted.");
        }
    }

    private static boolean isSorted(int[] arr, int n) {
        //base case
        if(n==0||n==1){
            return true;
        }
        if(arr[n-2]>arr[n-1]){
            return false;
        }else{
           boolean ans = isSorted(arr, n-1);
           return ans;
        }
        
    }
    
}
