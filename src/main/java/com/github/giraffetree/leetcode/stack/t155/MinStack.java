package com.github.giraffetree.leetcode.stack.t155;

import java.util.ArrayList;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    private int[] stack;
    private int[] min;
    private int count = 0;
    private int len;
    private int minCount = 0;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new int[1024];
        min = new int[1024];
        len = stack.length;
    }

    public void push(int x) {
        if (count == 0) {
            // 存入索引
            min[0] = (len - 1);
            minCount++;
        } else {
            // 存入索引
            int index = min[minCount - 1];
            if (stack[index] > x) {
                min[minCount] = len - count - 1;
                minCount++;
            }
        }
        stack[len - count - 1] = x;
        count++;
    }

    public void pop() {
        if (min[minCount - 1] == len - count) {
            min[minCount - 1] = 0;
            minCount--;
        }
        stack[len - count] = 0;
        count--;
    }

    public int top() {
        return stack[len - count];
    }

    public int getMin() {
        if (count == 0) {
            throw new NullPointerException();
        }
        return stack[min[minCount - 1]];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */