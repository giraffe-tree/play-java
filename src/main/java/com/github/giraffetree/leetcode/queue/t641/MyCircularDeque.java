package com.github.giraffetree.leetcode.queue.t641;

/**
 * @author GiraffeTree
 * @date 2018-12-26
 */
public class MyCircularDeque {

    private int[] content;
    private int front = 0;
    private int last = 0;
    private int count = 0;
    private int length;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        if (k < 0) {
            k = 1;
        }
        content = new int[k + 1];
        length = k + 1;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        int nextFront = getNextFront();
        content[nextFront] = value;
        front = nextFront;
        count++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        int nextLast = getNextLast();
        content[last] = value;
        last = nextLast;
        count++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        content[front] = 0;
        front = getBeforeFront();
        count--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        int beforeLast = getBeforeLast();
        content[beforeLast] = 0;
        last = beforeLast;
        count--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return content[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return content[getBeforeLast()];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return length == count + 1;
    }

    private int getNextFront() {
        if (front == 0) {
            return length - 1;
        }
        return front - 1;
    }

    private int getNextLast() {
        if (last == length - 1) {
            return 0;
        }
        return last + 1;
    }

    private int getBeforeFront() {
        if (front == length - 1) {
            return 0;
        }
        return front + 1;
    }

    private int getBeforeLast() {
        if (last == 0) {
            return length - 1;
        }
        return last - 1;
    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */