package algorithms;
// TODO:
public class Fibonacci {
    public static int iterative(int n){
        if(n <= 1)
            return n;
        else{
            int n1 = 0;
            int n2 = 1;
            for(int i = 2; i < n+1; i++){
                int temp = n2;
                n2+=n1;
                n1 = temp;
            }
            return n2;
        }

    }
    public static int recursive(int n){
        if(n <=1)
            return n;
        else
            return recursive(n-1) + recursive(n-2);
    }
    public static void main(String[] args){
        int n = 5;
        int result1 = iterative(n);
        int result2 = recursive(n);
        System.out.println("n = "+n);
        System.out.println("Iterative: "+result1);
        System.out.println("Recursive: "+result2);

    }
    
}
