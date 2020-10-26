package datastructures.queue;

import datastructures.stack.Stack;
import datastructures.stack.StackNode;

public class Queue {

    private QueueNode head;
    private QueueNode tail;
    private Integer size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(QueueNode node) {

        QueueNode cursor = this.head;

        if(cursor == null) {
            this.head = node;
            this.size++;
            return;
        }
        while(cursor.getNext() != null) {
            cursor = cursor.getNext();
        }
        cursor.setNext(node);
        this.size++;
    }

    public QueueNode dequeue() {
        QueueNode cursor = this.head;

        // queue is empty
        if(cursor == null) {
            return null;
        }

        this.head = this.head.getNext();
        return cursor;
    }

    public void printQueue() {
        QueueNode cursor = this.head;
        if(cursor == null) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Queue size: " + this.size);
        System.out.print("[");
        while(cursor.getNext() != null) {
            System.out.print(cursor.getValue() + ", ");
            cursor = cursor.getNext();
        }
        System.out.println(cursor.getValue() + "]");
    }

    public static void main(String[] args) {

        Queue queue = new Queue();

        queue.printQueue();
        for(int i = 0; i < 10; i++) {
            QueueNode<String> node = new QueueNode<>("S " + i);
            queue.enqueue(node);
        }
        queue.printQueue();

        for(int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        queue.printQueue();

        for(int i = 0; i < 5; i++) {
            queue.enqueue(new QueueNode<Integer>(i));
        }
        queue.printQueue();

        for(int i = 0; i < 12; i++) {
            queue.dequeue();
        }
        queue.printQueue();

    }
}
