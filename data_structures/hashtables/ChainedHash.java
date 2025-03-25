package data_structures.hashtables;
import data_structures.linked_lists.SLL;
//Has a linked list for each element of the array which is used to map different values
public class ChainedHash {
    public SLL[] arr; // Initialized an integer array of linked lists
    public int size;
    public ChainedHash(int size){
        this.size = size;
        arr = new SLL[size];
        for(int i = 0; i < size; i++){
            arr[i] = new SLL(); //uses up space for each ith element
        }
    }
    public int hashFunction(int key){
        return (key%size);
    }
    public void insertItem(int key){
        int index = hashFunction(key);
        SLL.insert(arr[index],key);
        /* Time Complexity: Average O(1) if the linked list for key is small, 
        else O(n) if the index we're adding to has a large linked list 
        (hashing fails to properly distribute the keys) */
    }
    public void deleteItem(int key){
        int index = hashFunction(key);
        if(!SLL.findKey(arr[index].head,key)) //If the key isnt even in the array, exit out of the funtion
            return;
        SLL.remove(arr[index],key);
        /*Deleting an Item is also O(1) on average for the same reason
         * and becomes O(n) if there is a large linked list for arr[index]
         */
    }
    public void displayHash(){
        System.out.println("Chained Hashset");
        for(int i = 0; i < size; i++){
            System.out.print(i);
            SLL.printList(arr[i]);
            System.out.println();
        }
        /*
         * In best case it will be O(n) where we traverse once through the list,
         * in average case it will take O(n+k), where k is the total number 
         * of elements in the list if they hash to one index
         * Worst Case (All the keys hash to a single index): O(n^2)
         */
    }
    public static void main(String[] args)
    {
       // Create a chained hash table of size 5
       ChainedHash table = new ChainedHash(5);

       // Insert some keys
       table.insertItem(10); // goes to index 0 (10 % 5)
       table.insertItem(15); // goes to index 0 (15 % 5)
       table.insertItem(7);  // goes to index 2 (7 % 5)
       table.insertItem(22); // goes to index 2 (22 % 5)
       table.insertItem(3);  // goes to index 3
       table.insertItem(18); // goes to index 3
       table.insertItem(5);  // goes to index 0 (collision)

       System.out.println("Initial Hash Table:");
       table.displayHash();

       // Delete a key
       table.deleteItem(15); // Should remove from index 0
       table.deleteItem(100); // Not found, should silently skip

       System.out.println("\nAfter Deleting 15 and 100:");
       table.displayHash();

       // Delete another
       table.deleteItem(3); // index 3
       System.out.println("\nAfter Deleting 3:");
       table.displayHash();
    }
}
/*
 * Reference: https://www.geeksforgeeks.org/c-program-hashing-chaining/
 */
