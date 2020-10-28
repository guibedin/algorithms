package datastructures.hashtable;

public class HashList<K, V> {

    protected HashListNode<K, V> head;

    public HashList() {
        this.head = null;
    }

    public void addNode(HashListNode<K, V> node) {
        // first node
        if(this.head == null) {
            this.head = node;
            return;
        }
        HashListNode cursor = this.head;

        // if key already exists
        while(cursor.getNext() != null) {

            if(cursor.getKey().equals(node.getKey())) {
                cursor.setValue(node.getValue());
                return;
            }
            cursor = cursor.getNext();
        }

        // check if last key exists
        if(cursor.getKey().equals(node.getKey())) {
            cursor.setValue(node.getValue());
            return;
        }

        // key doesn't exist, add at end of list
        cursor.setNext(node);
    }

    public HashListNode<K, V> findNode(K key) {

        HashListNode<K, V> cursor = this.head;

        while(cursor != null) {
            if(cursor.getKey().equals(key)) {
                return cursor;
            }
            cursor = cursor.getNext();
        }
        return null;
    }

    public boolean removeNode(K key) {
        HashListNode<K, V> cursor1 = this.head;
        HashListNode<K, V> cursor2 = this.head;

        // Removing first node
        if(cursor1.getKey().equals(key)) {
            this.head = this.head.getNext();
            return true;
        }

        if(cursor1 != null) {
            cursor2 = cursor1.getNext();
        }

        while(cursor2 != null) {
            // Key found. cursor1.next -> cursor2.next
            if(cursor2.getKey().equals(key)) {
                cursor1.setNext(cursor2.getNext());
                cursor2 = null;
                return true;
            }
            cursor1 = cursor1.getNext();
            cursor2 = cursor2.getNext();
        }
        return false;
    }

    public HashListNode<K, V> getHead() {
        return head;
    }

    public void setHead(HashListNode<K, V> head) {
        this.head = head;
    }
}
