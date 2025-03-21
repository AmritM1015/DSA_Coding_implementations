public class InsertionSort{
    public static void sort(int[] A, int n){
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
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = { 10, 14, 28, 11, 7, 16, 30, 50, 25, 18 };
        sort(arr,arr.length);
        printArray(arr);
    }
}