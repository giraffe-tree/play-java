package com.github.giraffetree.leetcode.linkedlist.t206;

/**
 * @author GiraffeTree
 * @date 2018/12/19
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = null;

        list(t1);
        ListNode listNode = reverseList(t1);
        list(listNode);
    }

    public static void list(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.printf("%d ", t.val);
            t = t.next;
        }
        System.out.println("\n");
    }

    public static ListNode reverseList(ListNode head) {

        // 当前节点的上一个节点
        ListNode previous = null;
        // 当前节点的下一个节点
        ListNode next = head;
        ListNode current = null;
        while (next != null) {
            // 获取当前节点
            current = next;
            // 获取下个节点
            next = next.next;
            // 当前节点
            current.next = previous;
            // 将下一个节点的上一个节点指向现在的节点
            previous = current;
        }
        return current;
    }
}
