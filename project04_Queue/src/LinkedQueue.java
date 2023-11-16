import LinkedList.SingleLinkedList;

public class LinkedQueue<E> {
    private SingleLinkedList<E> list = new SingleLinkedList<>();
    public LinkedQueue() {

    }
    /**
     * 向队尾添加元素,
     * or returns {@code null} if this queue is empty.
     */
    public void offer(E e) {
        list.addLast(e);
    }

    /**
    * 删除并返回队头元素
    * 为空返回 {@code NoSuchElementException}
    * @return queue的头, 如果为空返回 {@code NoSuchElementException}
    * */
    public E poll() {
        return list.removeFirst();
    }

    public E peek() {
        return list.getFirst();
    }



}
