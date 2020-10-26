package datastructures.linkedlist;

public class ListNode {
    protected Integer value;
    protected ListNode next;

    ListNode(Integer value) {
        this.value = value;
        this.next = null;
    }

    public Integer getValue() {
        return this.value;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
