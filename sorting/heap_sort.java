package sorting;

import java.util.Scanner;

public class heap_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        heapSort(arr,n);
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void buildHeap(int arr[], int n){
        // Your code here
        for(int i=n/2; i>=0; i--){
            heapify(arr,n,i);
        }
    }
 
    //Heapify function to maintain heap property.
    private static void heapify(int arr[], int n, int i){
        // Your code here
        int parent = i;
        int left = 2*i;
        int right = 2*i+1;
        int largest = parent;
        if(left<=n&&arr[left]>arr[largest]){
            largest = left;
        }
        if(right<=n&&arr[right]>arr[largest]){
            largest = right;
        }
        if(arr[parent]<arr[largest]){
            int temp = arr[parent];
            arr[parent] = arr[largest];
            arr[largest] = temp;
            
            heapify(arr,n,largest);
        }
    }
    
    //Function to sort an array using Heap Sort.
    private static void heapSort(int arr[], int n){
        //code here
        int heapsize = n-1;
        buildHeap(arr,heapsize);
        while(heapsize>0){
            int temp = arr[0];
            arr[0] = arr[heapsize];
            arr[heapsize] = temp;
            
            heapsize--;
            heapify(arr,heapsize,0);
        }
    }
    
}
