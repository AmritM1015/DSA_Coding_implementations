package algorithms;
//TODO
public class Horner {
    /*Naive implementation of horner's algorithm that runs a for loop of 
     i-1(approximately n) inside another for loop of n elements.
     The reason why i-1 is changed to n is because:
     for i = 1 j has iterations, for i=2 j has 1 interation,
     and if we write the sum of the iterations, it becomes (n(n-1))/2, which is a
     arithmetic sequence that can be stated as running in Θ(n^2)*/
    public static int naive_horner(int A[], int x){
        int y = 0;
        int n = A.length;
        for(int i = 1; i < n; i++){
            int m = 1;
            for(int j = 0; j < i-1; j++){
                m = m*x;
            }
            y= y+ A[i] * m;
        }
        return y;

    }
     //"Polynomial Evaluation using Horner's Rule — O(n) time"
    public static int horner(int A[], int n, int x){
        int p = 0;
        for(int i = n; i > 0; i--)
            p = A[i] + x * p;
        return p;
    }
    public static void main(String[] args) {
        
    }
    
}
/*
Reference: https://atekihcan.github.io/CLRS/02/P02-03/
*/
