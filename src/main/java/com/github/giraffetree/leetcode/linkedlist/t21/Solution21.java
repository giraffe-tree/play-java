package com.github.giraffetree.leetcode.linkedlist.t21;

import com.github.giraffetree.leetcode.linkedlist.t206.ListNode;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class Solution21 {


    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode c1 = head;

        while (true) {
            if (l1 == null) {
                c1.next = l2;
                break;
            }
            if (l2 == null) {
                c1.next = l1;
                break;
            }
            if (l1.val > l2.val) {
                c1.next = l2;
                c1 = c1.next;
                l2 = l2.next;
            }else {
                c1.next = l1;
                c1 = c1.next;
                l1 = l1.next;
            }
        }

        return head.next;
    }

}
