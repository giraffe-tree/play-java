package com.github.giraffetree.leetcode.sort.t922;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author GiraffeTree
 * @date 2019-01-14
 */
public class Solution922 {


    public static int[] sortArrayByParityII(int[] A) {
        // 上个多余的偶数
        Integer x1 = null;
        // 上个多余的奇数
        Integer x2 = null;
        boolean status;
        for (int i = 0; i < A.length; i++) {
            if ((status = ((i & 0x01) == 0)) ^ ((A[i] & 0x01) == 0)) {
                if (x2 == null && status) {
                    x2 = i;
                }
                if (x1 == null && !status) {
                    x1 = i;
                }
                if (x1 != null && x2 != null) {
                    // 交换 A[x1], A[x2]
                    int x = A[x1];
                    A[x1] = A[x2];
                    A[x2] = x;
                    if (x1 > x2) {
                        x2 += 2;
                        x1 = null;
                    } else {
                        x1 += 2;
                        x2 = null;
                    }
                }
            }
        }
        return A;
    }


    private static void swap(int[] arr, int a1, int a2) {

    }

    public static void main(String[] args) {

        //[4,1,2,2,3,1,4,0,1,1]
        int[] x = {4, 1, 2, 3, 2, 1, 4, 0, 1, 1};
        int[] ints = sortArrayByParityII(x);
        System.out.println(Arrays.toString(ints));

    }

}
