class Node{
    int val;
    Node next = null;
    Node prev = null;
}
class MyCircularDeque {
    Node head = null, tail = null;
    int size = 0, capacity = 0;
    public MyCircularDeque(int k) {
        capacity = k;
        head = new Node();
        head.val = -1;
        tail = new Node();
        tail.val = -1;
        head.next = tail;
        head.prev = tail;
        tail.next = head;
        tail.prev = head;
    }
    
    public boolean insertFront(int value) {
        if(size < capacity){
        Node node = new Node();
        node.val = value;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
        size++;
        return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) {
        if(size < capacity){
        Node node = new Node();
        node.val = value;
        node.next = tail;
        node.prev = tail.prev;
        node.prev.next = node;
        tail.prev = node;
        size++;
        return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        if(size != 0){
            head.next.next.prev = head;
            head.next = head.next.next;
            size--;
            return true;
        }
        return false;
    }
    
    public boolean deleteLast() {
        if(size != 0){
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            size--;
            return true;
        }
        return false;
    }
    
    public int getFront() {
        if(size != 0)
        return head.next.val;
        return -1;
    }
    
    public int getRear() {
        if(size != 0)
        return tail.prev.val;
        return -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
