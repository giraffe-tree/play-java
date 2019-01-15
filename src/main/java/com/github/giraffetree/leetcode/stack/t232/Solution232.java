package com.github.giraffetree.leetcode.stack.t232;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class Solution232 {

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

        private Node head = new Node(null, 0);
        private Node tail = null;
        int count = 0;

        class Node {
            Node next;
            int val;

            Node(Node next, int val) {
                this.next = next;
                this.val = val;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (tail == null) {
                head.next = new Node(null, x);
                tail = head.next;
                count++;
                return;
            }

            // 不为空
            tail.next = new Node(null, x);
            tail = tail.next;
            count++;
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            Node next = head.next;
            if (count == 1) {
                count--;
                int val = tail.val;
                tail = null;
                return val;
            }
            count--;
            head.next = head.next.next;

            return next.val;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return head.next.val;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return count == 0;
        }
    }

}
