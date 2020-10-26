package datastructures.stack;

public class StackNode<T> {

    protected T value;
    protected StackNode<T> previous;

    public StackNode(T value) {
        this.value = value;
        this.previous = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public StackNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(StackNode<T> previous) {
        this.previous = previous;
    }
}
