package com.github.giraffetree.leetcode.stack.t232;

import java.util.Stack;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class Solution232_2 {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(1);
        myQueue.push(1);
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        System.out.println(myQueue.peek());
    }

    /**
     * 使用栈实现队列的下列操作：
     * <p>
     * push(x) -- 将一个元素放入队列的尾部。
     * pop() -- 从队列首部移除元素。
     * peek() -- 返回队列首部的元素。
     * empty() -- 返回队列是否为空。
     */
    static class MyQueue {
        Stack<Integer> in = null;
        Stack<Integer> out = null;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            return in.pop();
        }

        public int peek() {//不空的时候，直接查询返回即可

            return in.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

}
