package sorting;

public class HeapSort {
    public static void sort(int A[], int n){
        for (int k = 0; k < n-1; k++){
            int i = k;
            while(i > 0 && A[(i-1)/2] < A[i]){
                int temp = A[(i-1)/2];
                A[(i-1)/2] = A[i];
                A[i] = temp;
                i = (i-1)/2;
            }
        }
        for(int k = n-1; k > 0; k--){
            int temp = A[0];
            A[0] = A[k];
            A[k] = temp;
            make_heap(A,k);
        }
    }
    public static void make_heap(int A[], int N){
        int i = 0;
        int j;
        while (i<N){
            if (2*i+2 < N){
                if(A[i] < A[2*i+1] || A[i] < A[2*i+2]){
                    if(A[2*i+1] > A[2*i+2]){
                        j = 2*i+1;      
                    }
                    else{
                        j = 2*i+2;
                    }
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    i = j;

                }
                else
                    break;
            }
            else if (2*i+1 < N){
                if(A[i] < A[2*i+1]){
                    int temp = A[i];
                    A[i] = A[2*i+1];
                    A[2*i+1] = temp;
                }
                else
                    break;
            }
            else
                break;
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
