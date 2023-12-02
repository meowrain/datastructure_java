import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list1 = new SingleLinkedList<>();
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);
        list1.addLast(7);
        list1.addLast(9);

        SingleLinkedList<Integer> list2 = new SingleLinkedList<>();
        list2.addLast(2);
        list2.addLast(4);
        list2.addLast(6);
        list2.addLast(8);
        list2.addLast(10);
        SingleLinkedList<Integer> mergedList = SingleLinkedList.mergeTwoLinkList(list1, list2);
        mergedList.display();
    }
}
