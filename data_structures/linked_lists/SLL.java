package data_structures.linked_lists;
public class SLL {
    public Node head; // head of the list
    public static class Node{ // A single node of a linked list
        int data;
        public Node next;
        //Constructor
        Node(int d){
            data = d;
            next = null;
        }
 
    }
    //Insert Node
    public static SLL insertAtNthNode(SLL list, int data, int index){
        if (index < 0) {
            System.err.println("Invalid index: " + index);
            return list;
        }
        Node dummy_node = new Node(data); //Allocates some memory to a dummy node
        if(list.head == null){//if the list is empty then insert at the head
            dummy_node.next = list.head;
            list.head = dummy_node; 
            return list;
        }
        Node curr = list.head;
        int count = 0;
        while (curr != null && count < index-1){ //traverse through the list until we get to the tail
            curr = curr.next;
            count++;
        }
        if(curr == null){
            System.err.println("Invalid index: " + index);
            return list;
        }
        dummy_node.next = curr.next;
        curr.next = dummy_node;
        return list;
    }
    // Insert at the end (tail) of the list
    public static SLL insert(SLL list, int data) {
        Node newNode = new Node(data);

        // If the list is empty, set head to the new node
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node curr = list.head;
            // Traverse to the last node
            while (curr.next != null) {
                curr = curr.next;
            }
            // Link new node at the end
            curr.next = newNode;
        }

        return list;
    }
    public static void printList(SLL list){
        //System.out.print("Linked List: ");
        for(Node curr = list.head; curr != null; curr=curr.next){
            System.out.print(" --> "+curr.data);
        }
        System.out.println("");
    }
    public static SLL remove(SLL list, int data) {
        // If the list is empty
        if (list.head == null) {
            System.err.println("Cannot remove from an empty list.");
            return list;
        }
    
        // If the head node holds the data to be deleted
        if (list.head.data == data) {
            list.head = list.head.next;
            return list;
        }
    
        // Traverse the list to find the node before the one to delete
        Node curr = list.head;
        while (curr.next != null && curr.next.data != data) {
            curr = curr.next;
        }
    
        // If the node was found, delete it
        if (curr.next != null && curr.next.data == data) {
            curr.next = curr.next.next;
        } else {
            System.err.println("Value " + data + " not found in the list.");
        }
    
        return list;
    }
    public static boolean findKey(Node head, int key){
        if(head == null)
            return false;
        if(head.data == key)
            return true;
        return findKey(head.next, key);
        
    }
    public static void main(String[] args) 
    { 
        /* Start with the empty list. */
        SLL list = new SLL(); 
  
        // 
        // ******INSERTION****** 
        // 
  
        // Insert the values 
        // list = insert(list, 10); 
        // list = insert(list, 5); 
        // list = insert(list, 20); 
        // list = insert(list, 15); 
        // list = insert(list, 8); 
        // list = insert(list, 6); 
        // list = insert(list, 7); 
        // list = insert(list, 1);   
        // Print the LinkedList 
        //     printList(list);
        // Insert at head when list is empty
        list = insertAtNthNode(list, 10, 0);         // [10]
        printList(list);

        // Insert at head again
        list = insertAtNthNode(list, 5, 0);          // [5 → 10]
        printList(list);

        // Insert at tail
        list = insertAtNthNode(list, 20, 2);         // [5 → 10 → 20]
        printList(list);

        // Insert in the middle
        list = insertAtNthNode(list, 15, 2);         // [5 → 10 → 15 → 20]
        printList(list);

        // Insert at index out of bounds
        list = insertAtNthNode(list, 99, 10);        // Invalid index
        printList(list);

        // Insert at last valid position (tail insert again)
        list = insertAtNthNode(list, 30, 4);         // [5 → 10 → 15 → 20 → 30]
        printList(list);

        // Insert negative index (invalid)
        list = insertAtNthNode(list, 999, -1);       // Should not insert
        printList(list);

    } 
    /*  
     Reference: https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/ 
    */
}
