package com.github.giraffetree.leetcode.linkedlist.t234;

import com.github.giraffetree.leetcode.linkedlist.t206.ListNode;

import java.util.Stack;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class Solution234 {


    /**
     * 快慢指针 + stack 实现
     */
    public boolean isPalindrome(ListNode head) {

        // 快慢指针
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast != null && fast.next != null) {
                stack.push(slow);
                slow = slow.next;
                fast = fast.next.next;
                continue;
            }
            break;
        }
        // slow 为中点, (偶数队列的第二个中点)
        // stack 中不包含中点
        if (fast != null) {
            // 奇数
            slow = slow.next;
        }

        while (true) {
            if (slow == null) {
                return true;
            }
            ListNode pop = stack.pop();
            if (pop.val != slow.val) {
                return false;
            }
            slow = slow.next;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution234 solution234 = new Solution234();
        solution234.isPalindrome_2(l1);

    }

    /**
     * 此答案是错的!!
     * 来源 leetcode-cn 0ms 范例
     */
    public boolean isPalindrome_2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast.next != null) {
            // 不停的从slow的后一个开始遍历，知道找到值相同的节点
            // 一次完成后，再移动到原节点的下一个节点开始，继续重复上面的步骤
            if (fast.next.val == slow.val) {
                if (fast.next.next != null) {
                    return false;
                }
                fast.next = null;
                slow = slow.next;
                fast = slow.next;
                if (fast == null || fast.val == slow.val) {
                    return true;
                }
            } else {
                fast = fast.next;
            }
        }
        return false;

    }

}
