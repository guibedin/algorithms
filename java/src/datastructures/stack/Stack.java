package datastructures.stack;

import datastructures.linkedlist.List;
import datastructures.linkedlist.ListNode;

public class Stack {

    private StackNode head;
    private Integer size;

    public Stack() {
        this.head = null;
        this.size = 0;
    }

    public void push(StackNode node) {

        if(this.size == 0) {
            this.head = node;
            this.size++;
            return;
        }

        node.previous = this.head;
        this.head = node;
        this.size++;
    }

    public StackNode pop() {
        StackNode node = this.head;

        // Stack is empty
        if(node == null) {
            return null;
        }

        this.head = this.head.getPrevious();
        this.size--;
        return node;
    }

    public void printStack() {
        StackNode cursor = this.head;
        if(cursor == null) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack size: " + this.size);
        System.out.print("[");
        while(cursor.getPrevious() != null) {
            System.out.print(cursor.getValue() + ", ");
            cursor = cursor.getPrevious();
        }
        System.out.println(cursor.getValue() + "]");
    }

    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.printStack();
        for(int i = 0; i < 10; i++) {
            StackNode<String> node = new StackNode<String>("S " + i);
            stack.push(node);
        }
        stack.printStack();

        for(int i = 0; i < 5; i++) {
            stack.pop();
        }
        stack.printStack();

        for(int i = 0; i < 5; i++) {
            stack.push(new StackNode<Integer>(i));
        }
        stack.printStack();

        for(int i = 0; i < 12; i++) {
            stack.pop();
        }
        stack.printStack();

    }
}
