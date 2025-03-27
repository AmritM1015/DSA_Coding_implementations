package data_structures.hashtables;
public class OpenAddressHash {
    public Integer arr[];
    Integer size;
    public OpenAddressHash(int size){
        this.size = size;
        arr = new Integer[size];
    }
    public int hashFunction(int key){
        int index = key%size;
        return index;
    }
    public int LinearProbing(int index){
        int i = index;
        while (true){
            if(arr[i] == null|| arr[index] == -1) // if the spot is empty then add the index
                return i;
            i=hashFunction(i+1); //%size keeps the index in bounds
            if (i == index){ // If i loops through the entire array we break out of the loop
                break;
            }
        }
        return -1; //Linear Probing could not find an index
    }
    public void insertLinear(int key){
        int index = hashFunction(key);
        if(arr[index] == null || arr[index] == -1){
            arr[index] = key;
            System.out.println("Key " + key + " inserted at index " + index);
            return;
        }
        index = LinearProbing(hashFunction(key+1));
        if (index != -1)
            arr[index] = key;
        else
            System.err.println("Hash Table is full");
    }
    public boolean findLinear(int key) {
        int index = hashFunction(key);
        int start = index;
        while(true){
            if(arr[index] == null)
                return false; // if we find that the index is empty, the key is not there
            if(arr[index] != -1 && arr[index].equals(key))
                return true;
            index = hashFunction(index+1);
            if(index == start)
                return false;
        }
    
    }
    public void deleteLinear(int key) {
        int index = hashFunction(key);
        int start = index;
    
        while (true) {
            if (arr[index] == null) {
                System.err.println("Key not found.");
                return;
            }
    
            if (arr[index].equals(key)) {
                arr[index] = -1; // Mark as deleted
                System.out.println("Key " + key + " deleted.");
                return;
            }
    
            index = (index + 1) % size;
    
            if (index == start) {
                System.err.println("Key not found.");
                return;
            }
        }
    }
    public int QuadraticProbing(int index){
        int i;
        int scale = 0;
        while (scale<=this.size){
            i=hashFunction(index+scale*scale); //Hash is quadratic in scale due to the exponentiation
            if(arr[i] == null|| arr[i] == -1) // if the spot is empty then add the index
                return i;            
            scale++; 
        }
        return -1; //Quadratic Probing could not find an index
    }
    public void insertQuad(int key){
        int index = QuadraticProbing(hashFunction(key));
        if (index != -1){
            arr[index] = key;
            System.out.println("Key " + key + " inserted at index " + index);
        }
        else
            System.err.println("Hash Table is full");
    }
    public boolean findQuad(int key) {
        int index = hashFunction(key);
        int scale = 0;
        while(scale<=size){
            int i = hashFunction(index+scale*scale);
            if(arr[i] == null)
                return false; // if we find that the index is empty, the key is not there
            if(arr[i].equals(key))
                return true;
            scale++;
        }
        return false;
    }
    public void deleteQuad(int key) {
        int index = hashFunction(key);
        int scale = 1;
    
        while (scale <= this.size) {
            int i = hashFunction(index+scale*scale);
            if (arr[i] == null) {
                System.err.println("Key not found.");
                return;
            }
    
            if (arr[i].equals(key)) {
                arr[i] = -1; // Mark as deleted
                System.out.println("Key " + key + " deleted.");
                return;
            }
    
            scale++;
        }
        System.err.println("Key not found.");
    }
    public static void main(String[] args) {
        OpenAddressHash hash = new OpenAddressHash(7); // Small size for easy testing
    
        System.out.println("=== LINEAR PROBING TEST ===");
    
        // Insert using linear probing
        hash.insertLinear(10);
        hash.insertLinear(17); // collision with 10 (10 % 7 == 3, 17 % 7 == 3)
        hash.insertLinear(24); // another collision
        hash.insertLinear(31); // should wrap around if needed
    
        // Search existing keys
        System.out.println("Find 17 (linear): " + hash.findLinear(17)); // true
        System.out.println("Find 99 (linear): " + hash.findLinear(99)); // false
    
        // Delete a key
        hash.deleteLinear(17);
        System.out.println("Find 17 after delete (linear): " + hash.findLinear(17)); // false
    
        System.out.println("\n=== QUADRATIC PROBING TEST ===");
    
        OpenAddressHash quadHash = new OpenAddressHash(7);
    
        // Insert using quadratic probing
        quadHash.insertQuad(10);
        quadHash.insertQuad(17); // collision with 10
        quadHash.insertQuad(24);
        quadHash.insertQuad(31);
    
        // Search
        System.out.println("Find 17 (quad): " + quadHash.findQuad(17)); // true
        System.out.println("Find 99 (quad): " + quadHash.findQuad(99)); // false
    
        // Delete and recheck
        quadHash.deleteQuad(17);
        System.out.println("Find 17 after delete (quad): " + quadHash.findQuad(17)); // false
    }
}
// Reference :  //Source: https://www.geeksforgeeks.org/program-to-implement-hash-table-using-open-addressing/