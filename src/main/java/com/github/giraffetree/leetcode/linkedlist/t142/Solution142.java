package com.github.giraffetree.leetcode.linkedlist.t142;

import com.github.giraffetree.leetcode.linkedlist.t206.ListNode;

/**
 * @author GiraffeTree
 * @date 2018/12/20
 */
public class Solution142 {

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     */
    public ListNode detectCycle(ListNode head) {

        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        int index = 0;
        ListNode p2 = head;
        while (true) {
            if (index != 0 && fast == slow) {
                break;
            }
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            index++;
        }
        while (true) {
            if (slow == p2) {
                break;
            }
            p2 = p2.next;
            slow = slow.next;
        }

        return p2;
    }

}
