package com.github.giraffetree.leetcode.sort.t973;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author GiraffeTree
 * @date 2019-01-15
 */
public class Solution973_2 {

    /**
     * 使用分治的思想
     * 参考快速排序
     */
    public static void main(String[] args) {

        Solution973_2 solution = new Solution973_2();
        int[][] points = {{1, 2}, {2, 3}, {1, 3}};

        solution.kClosest(points, 2);

    }

    int[][] points;

    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        work(0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void work(int i, int j, int K) {
        if (i >= j) return;
        int oi = i, oj = j;
        int i1 = ThreadLocalRandom.current().nextInt(i, j);
        int pivot = dist(i1);

        while (i < j) {
            while (i < j && dist(i) < pivot) i++;
            while (i < j && dist(j) > pivot) j--;
            swap(i, j);
        }

        if (K <= i - oi + 1)
            work(oi, i, K);
        else
            work(i + 1, oj, K - (i - oi + 1));
    }

    public int dist(int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    public void swap(int i, int j) {
        int t0 = points[i][0], t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }
}
