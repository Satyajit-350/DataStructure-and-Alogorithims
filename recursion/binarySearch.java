package recursion;

public class binarySearch {
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,4,6,7,8};
        boolean ans = bSearch(arr,0,5,8);
        if(ans){
            System.out.println("Element found.");
        }else{
            System.out.println("Element not found");
        }
    }

    private static boolean bSearch(int[] arr, int lb, int ub, int key) {
        //base case element not found
        if(lb>ub){
            return false;
        }
        print(arr,lb,ub);
        int mid = (lb+ub)/2;
        //bse case element found
        if(arr[mid]==key){
            return true;
        }
        if(arr[mid]<key){
            //right search
           return bSearch(arr,mid+1,ub,key);
        }else{
            //left search
            return bSearch(arr,lb,mid-1,key);
        }
    }

    private static void print(int[] arr, int lb, int ub) {
        for(int i=lb; i<=ub; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
}
