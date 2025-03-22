package algorithms;

public class BinarySearch {
    public static void InsertionSort(int[] A, int n){
        for(int i = 1; i < n; i++){
            int j = i;
            while(j >0 && A[j-1] > A[j] ){
                int temp = A[j];
                A[j] = A[j-1];
                A[j-1] = temp;
                j--; 
            }
        }
    }
    public static int search(int A[], int left, int right, int target){ //Recursive Approach to Binary Search T(n)
        if (left > right) //O(1)
            return -1;
        else{
            int middle = left+(right-left)/2;
            if(A[middle] == target)
                return middle;
            if(A[middle] < target)
                return search(A,middle+1,right,target); // T(n/2)
            return search(A,left,middle-1,target);// T(n/2)
        }
        //Time Complexity: O(log n) 
        // Binary Search is a dividing recurrence relation where the input size 
        // divides in half each step, performing one comparison per step.
        // This results in at most log₂(n) steps in total.

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
        InsertionSort(arr,arr.length); //used InsertionSort here to have the array in a sorted order
        printArray(arr);
        int n = arr.length;
        int x = 50;
        int result = search(arr, 0, n, x);
        if (result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at " + "index " + result);
    }
    
}
/*middle = (left+right)/2 
middle = left/2+right/2 + left/2 - left/2
middle = left + right/2-left/2
middle = left + (right-left)/2
 = */
