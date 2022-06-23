package recursion;

public class findSum {
    public static void main(String[] args) {
        int arr[] = new int[]{3,2,5,1,6};
        int ans = sum(arr,5);
        System.out.println("Sum is: "+ ans);
    }

    private static int sum(int[] arr, int n) {
        //base case
        if(n==0){
            return 0;
        }
        if(n==1){
            return arr[0];
        }
        int s = arr[n-1] + sum(arr,n-1);
        return s;
    }
}
