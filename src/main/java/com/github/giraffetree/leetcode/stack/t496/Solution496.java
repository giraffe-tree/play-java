package com.github.giraffetree.leetcode.stack.t496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author GiraffeTree
 * @date 2018-12-26
 */
public class Solution496 {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
}
