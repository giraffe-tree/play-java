package com.github.giraffetree.leetcode.linkedlist.t876;

import com.github.giraffetree.leetcode.linkedlist.t206.ListNode;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class Solution876 {

    // 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
    //
    // 如果有两个中间结点，则返回第二个中间结点。
    public ListNode middleNode(ListNode head) {
        // 双指针
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                continue;
            }
            break;
        }
        // 奇偶判定
        if (fast == null) {
            return slow;
        }

        return slow;
    }

}
