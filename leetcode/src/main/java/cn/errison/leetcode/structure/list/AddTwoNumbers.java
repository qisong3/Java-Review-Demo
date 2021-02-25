package cn.errison.leetcode.structure.list;


import cn.errison.leetcode.common.definition.ListNode;

/**
 * <p>You are given two <b>non-empty</b> linked lists representing two non-negative integers. The digits are stored in <b>reverse order</b> and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.</p>
 *
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>
 *
 * <p><b>Example:</b></p>
 *
 * <pre>
 * <b>Input:</b> (2 -&gt; 4 -&gt; 3) + (5 -&gt; 6 -&gt; 4)
 * <b>Output:</b> 7 -&gt; 0 -&gt; 8
 * <b>Explanation:</b> 342 + 465 = 807.
 * </pre>
 * <div><div>Related Topics</div><div><li>链表</li><li>数学</li></div></div>\n<div><li>👍 4794</li><li>👎 0</li></div>
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1, l2;
        Solution solution = new AddTwoNumbers().new Solution();
//        l1 = ListNode.genList(new int[]{2, 4, 3});
//        l2 = ListNode.genList(new int[]{5, 6, 4});
//        ListNode.print(solution.addTwoNumbers(l1, l2));
//        l1 = ListNode.genList(new int[]{1, 9});
//        l2 = ListNode.genList(new int[]{1, 1});
//        ListNode.print(solution.addTwoNumbers(l1, l2));
//        l1 = ListNode.genList(new int[]{1, 8});
//        l2 = ListNode.genList(new int[]{0});
//        ListNode.print(solution.addTwoNumbers(l1, l2));
//        l1 = ListNode.genList(new int[]{5});
//        l2 = ListNode.genList(new int[]{5});
//        ListNode.print(solution.addTwoNumbers(l1, l2));
//        l1 = ListNode.genList(new int[]{1});
//        l2 = ListNode.genList(new int[]{9,9});
//        ListNode.print(solution.addTwoNumbers(l1, l2));
        l1 = ListNode.genList(new int[]{9});
        l2 = ListNode.genList(new int[]{9});
        ListNode.print(solution.addTwoNumbers(l1, l2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode combine = new ListNode(-1);
            boolean flag = false;
            while (l1 != null && l2 != null) {
                int num = l1.val + l2.val;
                flag = addNode(combine, num, flag);
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                flag = addNode(combine, l1.val, flag);
                l1 = l1.next;
            }
            while (l2 != null) {
                flag = addNode(combine, l2.val, flag);
                l2 = l2.next;
            }
            if (flag) {
                addNode(combine, 1, false);
            }
            return removeHeadZero(reverseList(combine.next));


        }

        private ListNode removeHeadZero(ListNode head) {
            ListNode tmpHead = head;
            while (tmpHead.next != null) {
                tmpHead = tmpHead.next;
            }
            return head;
        }

        public boolean addNode(ListNode head, int num, boolean flag) {
            if (flag) {
                num += 1;
            }
            if (num >= 10) {
                num -= 10;
                flag = true;
            } else {
                flag = false;
            }
            ListNode node = new ListNode(num);
            node.next = head.next;
            head.next = node;
            return flag;
        }

        public ListNode reverseList(ListNode list) {
            if (list == null) {
                return null;
            }
            ListNode head = list;
            ListNode tmp = null;
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
//leetcode submit region end(Prohibit modification and deletion)

}