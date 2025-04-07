package data_structures.queues;

public class Deque<T> {
    private class Node{
        T data;
        Node next;
        Node prev;
        Node(T data){
            this.data = data;
        }
    }
    private Node front;
    private Node back;
    private int size;
    public Deque(){
        front = back = null;
        size = 0;
    }
    public void addFirst(T value){ //Push (Stack)
        Node node = new Node(value);
        if(front == null){
            front = node;
        }
        else{
            node.next = front;
            front.prev = node;
            front = node;
        }
        size++;
    }
    public void addLast(T value){ //Enqueue(Queue)
        Node node = new Node(value);
        if(isEmpty()){
            front = back = node; //if the deque is empty then both the front and back are the same
        }
        else{
            back.next = node; //We're linking the node to the back
            node.prev = back;
            back = node;
        }
        size++;
    }
    public T popLeft(){ //Pop (Stack)
        if(isEmpty()){
            return null; //There is no node to be popped
        }
        T value = front.data;
        if(front == back){
            front = back = null; // If the deque has one element it turns empty with pop
        }
        else{
            front = front.next;
            front.prev = null;
        }
        size--;
        return value;
    }
    public T popRight(){ //Dequeue(Stack)
        if(isEmpty()){
            return null; //There is no node to be popped
        }
        T value = back.data;
        if(front == back){
            front = back = null; // If the deque has one element it turns empty with pop
        }
        else{
            back = back.prev;
            back.next = null;
        }
        size--;
        return value;
    }
    public T peekFirst(){
        if (isEmpty()){
            return null;
        }
        else{
            return front.data;
        }
    }
    public T peekLast(){
        if(isEmpty()){
            return null;
        }
        else{
            return back.data;
        }
    }
    public void clear(){
        front = back = null;
        size = 0;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
}
