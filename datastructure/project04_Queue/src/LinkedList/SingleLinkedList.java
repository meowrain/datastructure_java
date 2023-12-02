package LinkedList;/*
 * @Author: meowrain meowrain@126.com
 * @Date: 2023-11-03 12:11:07
 * @LastEditors: meowrain meowrain@126.com
 * @LastEditTime: 2023-11-03 22:44:22
 * @FilePath: \datastructureWithJava\project02_linklist\src\LinkedList.SingleLinkedList.java
 * @Description: "单链表Java实现"
 */


/*
 *
 * 这个代码中，索引是从首元节点才开始算的，也就是首元节点索引为0，所以索引值是比size小1的
 *
 * */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E> {

    private static class Node<E> { // 静态内部类，声明节点
        E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
        }
    }

    private final Node<E> head, tail; // 声明头节点和尾节点
    private int size;

    public SingleLinkedList() { // 构造函数初始化头尾节点
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        this.size = 0;
    }

    /* 增 */
    public void addFirst(E element) {
        Node<E> x = new Node<>(null);
        x.val = element; // 创建要插入的节点
        Node<E> temp = head.next; // 保存头节点的下一个节点
        x.next = temp; // 让x的next指针指向head的下一个节点
        head.next = x;// 让head的next指针指向新节点x
        size++;// 然后让链表元素长度加1
    }

    public void addLast(E element) {
        Node<E> x = new Node<E>(element);
        Node<E> temp;
        if (size - 1 >= 0) {
            temp = getNode(size - 1);
        } else {
            temp = head;
        }

        x.next = tail;
        temp.next = x;
        size++;
    }

    public void add(int index, E element) {
        checkPositionIndex(index);
        // 判断特殊情况
        if (index == size) {
            addLast(element);
            return;
        }
        Node<E> x = new Node<E>(element);
        Node<E> p = getNode(index);
        Node<E> temp;
        if (index - 1 >= 0) {
            temp = getNode(index - 1);
        } else {
            temp = head;
        }
        temp.next = x;
        x.next = p;
        size++;
    }

    /* 删除 */
    public E removeFirst() {
        if (isEmpty()) { //如果为空，抛出没有元素的异常
            throw new NoSuchElementException();
        }
        Node<E> x = head.next; //保存头节点的下一个节点
        head.next = head.next.next;//让头节点的next指针指向它的下下个节点
        x.next = null; //让头节点的下一个节点的next指针指向null
        size--; //删除元素，size - 1
        return x.val; //返回头节点的下一个节点的val值
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> x = getNode(size - 1);
        Node<E> temp;
        if (size - 2 >= 0) {
            temp = getNode(size - 2);
        } else {
            temp = head;
        }
        temp.next = tail;
        x.next = null;
        size--;
        return x.val;
    }

    public E remove(int index) { //删除指定索引位置的节点
        /*
         * 注意：这里删除节点是不包括头节点的，删的是首元节点
         * 因为这个链表就是带头节点的链表，删节点也是删的非头节点
         * index为0表示的要删除的是首元节点，1时为首元节点的下一个节点
         * */
        checkElementIndex(index); //检查索引是否合法
        Node<E> p = getNode(index); //获取index索引位置的节点
        Node<E> prev;
        if (index - 1 >= 0) { //如果删除的index>=1，那要删除的就不是首元节点，是首元节点后面的节点
            prev = getNode(index - 1);
        } else { //否则，要删除的节点就是首元节点，这样的话，我们就把头节点的地址赋值给prev，此时prev 等同于 head
            prev = head;
        }
        Node<E> next = p.next; //获取index索引位置节点的下一个节点
        prev.next = next; //让前一个节点的next指针指向p节点的下一个节点
        p.next = null; //然后让p节点的next指针指向null，断绝和原来链表的联系
        size--;
        return p.val;//返货删除的节点的val值
    }

    /* 查 */
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> first = getNode(0);
        return first.val;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> last = getNode(size - 1);
        return last.val;
    }

    public E get(int index) {
        checkElementIndex(index);
        Node<E> p = getNode(index);
        return p.val;
    }

    /*改*/

    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> p = getNode(index); //找到索引位置的节点
        E oldVal = p.val; //存储旧值
        p.val = element;//修改节点的val值
        return oldVal;//返回旧值
    }

    /* 额外工具函数实现 */

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private Node<E> getNode(int index) {
        Node<E> p = head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    /* 合并链表 */
    public static <E extends Comparable<E>> SingleLinkedList<E> mergeTwoLinkList(SingleLinkedList<E> list1, SingleLinkedList<E> list2) {
        SingleLinkedList<E> newLinkList = new SingleLinkedList<>();
        Node<E> p1 = list1.head.next;
        Node<E> p2 = list2.head.next;
        while (p1.val != null && p2.val != null) {
            if (p1.val.compareTo(p2.val) > 0) {
                newLinkList.addLast(p2.val);
                p2 = p2.next;
            } else {
                newLinkList.addLast(p1.val);
                p1 = p1.next;
            }
        }
        while (p1.val != null) {
            newLinkList.addLast(p1.val);
            p1 = p1.next;
        }
        while (p2.val != null) {
            newLinkList.addLast(p2.val);
            p2 = p2.next;
        }
        return newLinkList;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E val = p.val;
                p = p.next; // 将指针移动到下一个节点
                return val;
            }
        };
    }
    public void display() {
        Node<E> current = head.next;
        while (current != tail) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

}

