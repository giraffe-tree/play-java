package com.github.giraffetree.leetcode.linkedlist.t141;

import com.github.giraffetree.leetcode.linkedlist.t206.ListNode;

/**
 * @author GiraffeTree
 * @date 2018/12/19
 */
public class Solution141 {
    public static boolean hasCycle(ListNode head) {
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        int index = 0;
        while (fast != null) {
            if (index != 0 && fast == slow) {
                return true;
            }
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            index++;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t1;

//        Solution.list(t1);
        boolean b = hasCycle(t1);
        System.out.println(b);
//        ListNode listNode = Solution.reverseList(t1);
//        Solution.list(listNode);


    }

}
