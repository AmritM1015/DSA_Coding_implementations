package data_structures.hashtables;

//TODO:
public class DirectAddressTable {
    public String[] arr;
    public final int DEFAULT_CAPACITY = 10001;

    /*Default Constructor */
    public DirectAddressTable(){
        arr = new String[DEFAULT_CAPACITY];
    }
    /*Constructor */
    public DirectAddressTable(int capacity){
        arr = new String[capacity+1];
    }
    public void insert(int k, String d){
        arr[k] = d; //O(1)
    }
    public void delete(int k){
        arr[k] = null; //O(1)
    }
    public String get(int k){
        return arr[k];//O(1)
    }
    public void clear(){
        int l = arr.length;
        arr = new String[l];
    }
    public void printTable(){
        System.out.println("Direct Adressing Table: ");
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null)
                System.out.print("{"+i+ ":"+arr[i]+"}");
        }
        System.out.println();

    }
    //Source: https://www.sanfoundry.com/java-program-implement-direct-addressing-tables/
}

