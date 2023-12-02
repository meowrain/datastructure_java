import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<E> implements Iterable<E> {

    //双链表节点构建
    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;

        Node(E val) {
            this.val = val;
        }
    }

    //虚拟头尾节点
    final private Node<E> head, tail;
    private int size;

    public DoubleLinkedList() { //构造器初始化
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /*增*/
    public void addFirst(E element) {
        Node<E> x = new Node<>(element); //创建要插入的节点
        Node<E> next = head.next;
        x.prev = head;
        x.next = next;
        head.next = x;
        next.prev = x;
        size++;

    }

    public void addLast(E element) {
        Node<E> x = new Node<>(element);
        Node<E> temp = tail.prev;
        temp.next = x;
        x.prev = temp;
        x.next = tail;
        tail.prev = x;
        size++;

    }

    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size) {
            addLast(element);
            return;
        }
        Node<E> p = getNode(index);
        Node<E> pre = p.prev;
        Node<E> x = new Node<>(element);
        p.prev = x;
        pre.next = x;
        x.prev = pre;
        x.next = p;
        size++;
    }

    /*删*/
    public E removeLast() {
        checkElementIndex(size - 1);
        Node<E> last = tail.prev;
        Node<E> last_prev = last.prev;
        last_prev.next = tail;
        tail.prev = last_prev;
        last.prev = null;
        last.next = null;
        size--;
        return last.val;
    }

    public E removeFirst() {
        checkElementIndex(0);
        Node<E> first = head.next;
        Node<E> first_next = first.next;
        head.next = first_next;
        first_next.prev = head;
        first.prev = null;
        first.next = null;
        size--;
        return first.val;

    }

    public E remove(int index) {
        checkElementIndex(index);
        Node<E> node = getNode(index);
        Node<E> node_prev = node.prev;
        Node<E> node_next = node.next;
        node_prev.next = node_next;
        node_next.prev = node_prev;
        node.next = null;
        node.prev = null;
        size--;
        return node.val;
    }

    /*改*/
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> p = getNode(index);
        E oldval = p.val;
        p.val = element;
        return oldval;
    }

    /*查*/
    public E get(int index) {
        checkElementIndex(index);
        Node<E> p = getNode(index);
        E val = p.val;
        return val;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.prev.val;
    }

    /* 工具函数 */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> p = head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void display() {
        System.out.println("size=" + size);
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
            System.out.println(temp.val + " -> ");
        }
//        for(Node<E> p = head.next;p!=tail;p = p.next) {
//            System.out.println(p.val + "-> ");
//        }
        System.out.println("null");
        System.out.println();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() { //用匿名内部类实现接口内的方法
            Node<E> p = head.next; //p指针指向首元节点

            @Override
            public boolean hasNext() {
                return p != tail; //只要p不是尾节点，那就一定next有指向的下一个节点
            }

            @Override
            public E next() {
                E val = p.val;
                p = p.next;
                return val;
            }
        };
    }
}
