package com.github.giraffetree.leetcode.sort.t349;

import java.util.HashSet;
import java.util.Set;

/**
 * @author GiraffeTree
 * @date 2019-01-15
 */
public class Solution349 {

    /**
     * 思路:
     * 1. 暴力法 时间复杂度O(n^2)
     * 2. hashset 法 O(n)
     * 3. 在2的基础上用 array 优化
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
