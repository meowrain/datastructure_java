import java.util.NoSuchElementException;

public class LinkedStack<E> {
    private Node<E> top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(E element) {
        Node<E> node = new Node<>(element);
        node.next = top;
        top = node;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is Empty");
        }
        E oldval = top.data;
        top = top.next;
        size--;
        return oldval;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is Empty");
        }
        return top.data;

    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
}
