import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKOrderlySequence {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        //虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        //优先队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(a,b)->(a.val - b.val));
        //把k个链表的头节点加入最小堆
        for(ListNode head : lists) {
            if(head != null) {
                pq.add(head);
            }
        }

        while(!pq.isEmpty()){
            //获取最小节点，接到结果链表中
            ListNode node = pq.poll(); //获取并删除堆顶元素(也就是最大优先级元素)
            p.next = node;
            if(node.next != null){
                pq.add(node.next);
            }
            //p指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
