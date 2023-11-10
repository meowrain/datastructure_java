
public class MaxPQ<Key extends Comparable<Key>> {
    //存储元素得数组
    private Key[] pq;
    //当前优先队列中得元素个数
    private int size = 0;

    public MaxPQ(int cap) {
        //索引0不用，所以多分配一个空间
        pq = (Key[]) new Comparable[cap + 1];
    }

    /* 返回当前队列中的最大元素*/
    public Key max() {
        return pq[1];
    }

    private void swim(int x) {
        // 如果浮到堆顶，就不能再上浮了
        while (x > 1 && less(parent(x), x)) { //如果父亲更小且上浮的元素下标大于1
            //如果第x个元素比上层大
            //把x换上去
            swap(parent(x), x);
            x = parent(x);
        }
    }

    private void sink(int x) {
        //如果沉到堆的底部，就沉不下去了
        while (left(x) <= size) {
            //假设左边节点比较大
            int max = left(x);
            //如果右边节点存在，比较一下大小
            if (right(x) <= size && less(left(x), right(x))) {
                max = right(x);
            }
            //节点x比两个孩子都大,就不用下沉了
            if (less(max, x)) break;
            x = max;
        }
    }

    /*插入元素*/
    public void insert(Key element) {
        size++;
        //先加加，因为不用0号索引
        pq[size] = element;
        // 然后让它上浮到正确位置
        swim(size);
    }

    /*删除并且返回当前队列中的最大元素*/
    public Key delMax() {
        // 最大堆的堆顶就是最大元素
        Key max = pq[1];
        // 把这个最大元素换到最后，删除之
        swap(1, size);
        pq[size] = null; //置空
        size--;
        // 让 pq[1] 下沉到正确位置
        sink(1);
        return max;
    }

    /*交换数组的两个元素*/
    private void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /* pq[i] 是否比 pq[j] 小？ */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private int left(int x) {
        return 2 * x + 1;
    }

    private int right(int x) {
        return 2 * x + 2;
    }

    private int parent(int x) {
        return (x - 1) / 2;
    }
}
