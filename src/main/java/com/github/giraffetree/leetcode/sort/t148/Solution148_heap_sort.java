package com.github.giraffetree.leetcode.sort.t148;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author GiraffeTree
 * @date 2019-01-15
 */
public class Solution148_heap_sort {

    /**
     * 利用优先队列进行堆排序
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(11,Comparator.comparing((x)-> x.val));
        ListNode current = head;
        do {
            queue.add(current);
            current = current.next;
        } while (current != null);
        current = new ListNode(0);
        ListNode next = current;
        while (!queue.isEmpty()) {
            next.next = queue.poll();
            next = next.next;
        }
        next.next = null;
        return current.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node4;
        node4.next = node2;
        node2.next = node3;
        ListNode listNode = sortList(node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
