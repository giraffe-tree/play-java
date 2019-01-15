package com.github.giraffetree.leetcode.linkedlist.t19;

import com.github.giraffetree.leetcode.linkedlist.t206.ListNode;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class Solution19_2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

}
