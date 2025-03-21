public class MergeSort {
    public static void sort(int A[], int l, int r){
        if(l < r){
            int m = l+(r-l)/2;
            sort(A,l,m);
            sort(A,m+1,r);
            merge(A, l, m, r);
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void merge(int A[], int l, int m, int r){
        int nl = (m-l)+1;
        int nr = (r-m);
        int L[] = new int[nl];
        int R[] = new int[nr];
        int i;int j;int k;
        for(i = 0; i < nl; i++)
            L[i] = A[l+i];
        for(j = 0; j < nr;j++)
            R[j] = A[m+j+1];
        i = 0;
        j = 0;
        k = l;
        while(i < nl && j < nr){
            if(L[i]<=R[j]){
                A[k] = L[i];
                i++;
            }
            else{
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < nl){
            A[k] = L[i];
            i++;
            k++;
        }
        while(j < nr){
            A[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int arr[] = { 10, 14, 28, 11, 7, 16, 30, 50, 25, 18 };
        sort(arr, 0, arr.length-1);
        printArray(arr);
    }
    
}
