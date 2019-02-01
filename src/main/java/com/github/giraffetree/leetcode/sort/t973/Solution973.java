package com.github.giraffetree.leetcode.sort.t973;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * @author GiraffeTree
 * @date 2019-01-15
 */
public class Solution973 {

    /**
     * 使用最大堆
     * 时间复杂度 O(N+K)
     */
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> heap = new PriorityQueue<>(K);
        int length = points.length;
        if (K >= length) {
            return points;
        }
        for (int i = 0; i < length; i++) {
            if (heap.size() < K) {
                heap.add(new Point(points[i]));
            } else {
                Point peek = heap.peek();
                Point point = new Point(points[i]);
                assert peek != null;
                if (peek.sum > point.sum) {
                    heap.poll();
                    heap.add(point);
                }
            }
        }
        int[][] closest = new int[K][];
        Object[] objects = heap.toArray();

        for (int i = 0; i < K; i++) {
            closest[i] = ((Point) objects[i]).getPoint();
        }

        return closest;
    }

    class Point implements Comparable<Point> {
        int[] point;
        Integer sum;

        public Point(int[] point) {
            this.point = point;
            this.sum = point[0] * point[0] + point[1] * point[1];
        }

        public int[] getPoint() {
            return point;
        }

        public void setPoint(int[] point) {
            this.point = point;
        }

        public Integer getSum() {
            return sum;
        }

        public void setSum(Integer sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(Point o) {
            return -this.sum + o.sum;
        }
    }

    public static void main(String[] args) {

        Solution973 solution = new Solution973();
        int[][] points = {{1, 2}, {2, 3}, {3, 2}};
        int[][] ints = solution.kClosest(points, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }

}
