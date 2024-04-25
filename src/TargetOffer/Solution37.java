package TargetOffer;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author zlx
 * @Date 2024/4/24 9:33
 */
public class Solution37 {
}
class MedianFinder {
    private PriorityQueue<Integer> frontPQ;
    private PriorityQueue<Integer> posteriorPQ;
    public MedianFinder() {
        // 前置是一个大根堆
        frontPQ = new PriorityQueue<>((x, y) ->  Integer.compare(y, x));
        // 后置是一个小根堆
        posteriorPQ = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 保证左边的数量 >= 右边的数量
        if (frontPQ.isEmpty() || num <= frontPQ.peek()) {
            frontPQ.add(num);
        }else{
            posteriorPQ.add(num);
        }

        if (frontPQ.size() > posteriorPQ.size() + 1) {
            posteriorPQ.add(frontPQ.poll());
        } else if (frontPQ.size() < posteriorPQ.size()) {
            frontPQ.add(posteriorPQ.poll());
        }
    }

    public double findMedian() {
        if (frontPQ.size() == posteriorPQ.size()) {
            return (frontPQ.peek() + posteriorPQ.peek()) / 2.0;
        }else {
            return frontPQ.peek();
        }
    }
}
