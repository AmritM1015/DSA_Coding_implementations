package sorting;
public class BubbleSort {
    public static void sort(int A[],int n){
        for(int i = 0; i < n-1; i++){
            boolean swapped = false;
            for(int j = 0; j < n-i-1;j++){
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        // Time complexity: 
        // Worst/Average Case: O(n^2), inner loop performing n comparisons/swaps n times
        // Best Case O(n), BubbleSort modification that allows us to break out of the
        // inner loop if there was no swaps.
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = { 10, 14, 28, 11, 7, 16, 30, 50, 25, 18 };
        sort(arr,arr.length);
        printArray(arr);
    }
}
