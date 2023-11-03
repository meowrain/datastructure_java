/*
 * @Author: meowrain meowrain@126.com
 * @Date: 2023-11-03 12:11:07
 * @LastEditors: meowrain meowrain@126.com
 * @LastEditTime: 2023-11-03 22:44:22
 * @FilePath: \datastructureWithJava\project02_linklist\src\SingleLinkedList.java
 * @Description: "单链表Java实现"
 */

import java.util.NoSuchElementException;

public class SingleLinkedList<E> {
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
        Node<E> x = new Node<E>(null);
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
    public E removeLast(){
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> x = getNode(size - 1);
        Node<E> temp;
        if(size - 2 >= 0) {
            temp = getNode(size - 2);
        }else {
            temp = head;
        }
        temp.next = tail;
        x.next = null;
        size--;
        return x.val;
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

}