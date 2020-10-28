package datastructures.linkedlist;

public class ListNode<T> {

    protected T value;
    protected ListNode<T> next;

    public ListNode(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return this.value;
    }

    public ListNode<T> getNext() {
        return this.next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
