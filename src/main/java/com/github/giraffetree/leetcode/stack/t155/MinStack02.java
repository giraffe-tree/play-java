package com.github.giraffetree.leetcode.stack.t155;

import java.util.ArrayList;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class MinStack02 {

    public static void main(String[] args) {

        MinStack02 minStack = new MinStack02();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }

    private ArrayList<Integer> stack;
    private ArrayList<Integer> min;
    private int count = 0;

    /**
     * initialize your data structure here.
     */
    public MinStack02() {
        stack = new ArrayList<>(256);
        min = new ArrayList<>(64);
    }

    public void push(int x) {
        if (count == 0) {
            // 存入索引
            min.add(0);
        } else {
            // 存入索引
            Integer index = min.get(min.size() - 1);
            if (stack.get(index) > x) {
                min.add(stack.size());
            }
        }
        stack.add(x);
        count++;
    }

    public void pop() {
        if (min.get(min.size() - 1) == stack.size() - 1) {
            min.remove(min.size() - 1);
        }
        stack.remove(stack.size() - 1);
        count--;
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return stack.get(min.get(min.size() - 1));
    }
}
