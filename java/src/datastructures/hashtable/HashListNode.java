package datastructures.hashtable;

public class HashListNode<K, V> {

    protected K key;
    protected V value;
    protected HashListNode next;

    public HashListNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashListNode getNext() {
        return next;
    }

    public void setNext(HashListNode next) {
        this.next = next;
    }
}
