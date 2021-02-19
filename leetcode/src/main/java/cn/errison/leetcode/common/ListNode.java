package cn.errison.leetcode.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List节点定义
 */

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode genList(int[] array) {
        return genList(Arrays.stream(array).boxed().collect(Collectors.toList()));
    }

    public static ListNode genList(List<Integer> list) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        for (int num : list) {
            ListNode tmp = new ListNode(num);
            tail.next = tmp;
            tail = tmp;
        }
        return head.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null){
                System.out.print("-->");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode reverse(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode tmp;
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            tmp = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = tmp;
        }
        return newHead.next;
    }

}