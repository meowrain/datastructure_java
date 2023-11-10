import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayStack<E> {
    private int capacity;
    private int top;
    private ArrayList<E> arr = new ArrayList<>(capacity);

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive number");
        }
        this.capacity = capacity;
        this.top = -1;
    }

    public void push(E element) {
        if (top == capacity - 1) {
            throw new IllegalStateException("Stack is full");
        }
        top++;
        arr.add(element);
    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        E oldval = arr.remove(top);
        top--;
        return oldval;
    }
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return arr.get(top);
    }
    public boolean isEmpty() {
        return top == -1;
    }



    public E search(E element) {
        int point = top;
        while (point >= 0) {
            if (arr.get(point).equals(element)) {
                return arr.get(point);
            }
            point--;
        }
        return null;
    }
}
