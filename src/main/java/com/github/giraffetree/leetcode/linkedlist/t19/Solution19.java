package com.github.giraffetree.leetcode.linkedlist.t19;

import com.github.giraffetree.leetcode.linkedlist.t206.ListNode;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class Solution19 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        Solution19 solution19 = new Solution19();
        solution19.removeNthFromEnd(l1, 2);

    }

    // 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    // n>0, n<链表长度
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode x = head;
        if (head == null || head.next == null) {
            return null;
        }
        int len = 0;
        while (true) {
            if (head != null) {
                len++;
                head = head.next;
            } else {
                break;
            }
        }
        int index = len - n;
        head = x;
        if (index == 0) {
            return x.next;
        }
        int cur = 1;
        while (true) {
            if (index == cur) {
                if (head.next == null) {
                    return null;
                }
                head.next = head.next.next;
                break;
            }
            head = head.next;
            cur++;
        }


        return x;
    }


}
