package com.github.giraffetree.leetcode.linkedlist.t19;

import com.github.giraffetree.leetcode.linkedlist.t206.ListNode;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class Solution19_best {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 使用双指针

        ListNode p,q;
        p=head;
        q=head;
        while(n>0)
        {
            p=p.next;
            n--;
        }
        if(p==null)
        {
            head=head.next;
            return head;
        }
        while(p.next!=null)
        {
            p=p.next;
            q=q.next;
        }
        q.next=q.next.next;
        return head;
    }

}
