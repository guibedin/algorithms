package datastructures.linkedlist;

public class List {
    protected ListNode head;
    protected Integer size;

    public List() {
        this.head = null;
        this.size = 0;
    }

    public void addNode(ListNode node) {
        node.setNext(this.head);
        this.head = node;
        this.size++;
    }

    public boolean removeNode(Integer value) {

        ListNode cursor1 = this.head;

        if(cursor1.value == value) {
            this.size--;
            this.head = cursor1.getNext();
            return true;
        }

        ListNode cursor2 = cursor1.getNext();

        while(cursor2 != null) {
            if(cursor2.getValue() == value) {
                this.size--;
                cursor1.setNext(cursor2.getNext());
                return true;
            }
            cursor2 = cursor2.getNext();
            cursor1 = cursor1.getNext();
        }
        return false;
    }

    public void printList() {
        ListNode cursor = this.head;

        if(cursor == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("List size: " + this.size);
        System.out.print("[");
        while(cursor.getNext() != null) {
            System.out.print(cursor.getValue() + ", ");
            cursor = cursor.getNext();
        }
        System.out.println(cursor.getValue() + "]");
    }

    public ListNode getHead() {
        return head;
    }

    public static void main(String[] args) {
        List myList = new List();

        for(int i = 0; i < 10; i++) {
            ListNode<Integer> node = new ListNode<>(i);
            myList.addNode(node);
        }
        myList.printList();

        myList.removeNode(9);
        myList.removeNode(0);
        myList.removeNode(5);
        myList.removeNode(10);

        myList.printList();
    }
}