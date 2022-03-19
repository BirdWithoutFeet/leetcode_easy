package 剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
* 那么中位数就是所有数值排序之后位于中间的数值。
* 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
*
*
*
* 通过一个最大堆和一个最小堆来维护

。*/
public class Main41 {
    private PriorityQueue<Integer> bigDump;
    private PriorityQueue<Integer> smallDump;
    /** initialize your data structure here. */
    public Main41() {

        //构造大堆(默认大堆)
        this.bigDump = new PriorityQueue<Integer>();
        //构造小堆
        this.smallDump = new PriorityQueue<Integer>((o1, o2) -> o2-o1);
    }

    public void addNum(int num) {
        if (bigDump.size() != smallDump.size()){
//            奇数
            smallDump.offer(num);
            bigDump.offer(smallDump.poll());
        }else {
//            偶数
            bigDump.offer(num);
            smallDump.offer(bigDump.poll());
        }

    }

    public double findMedian() {
        if (bigDump.size() == smallDump.size())
            return (bigDump.peek()+smallDump.peek())/2.0;
        else
            return smallDump.peek();
    }
}
