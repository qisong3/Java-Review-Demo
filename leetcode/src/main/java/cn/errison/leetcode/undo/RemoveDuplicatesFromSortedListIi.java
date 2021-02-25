package cn.errison.leetcode.undo;

import cn.errison.leetcode.common.definition.ListNode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
//        ListNode head = ListNode.genList(new int[]{1, 1, 2, 3, 3});
//        ListNode head = ListNode.genList(new int[]{1, 1, 2, 3, 3});
        ListNode head = ListNode.genList(new int[]{1, 1, 1, 1, 1, 1, 1});
        head = solution.deleteDuplicates(head);
        ListNode.print(head);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode newHead = new ListNode(-1, head);
            ListNode tmpHead = newHead;
            int pre = head.val;
            head = head.next;
            while (head != null) {
                if (head.val == pre) {
                    head = head.next;
                    continue;
                }

                pre = head.val;

                if (head.next == null) {
                    tmpHead.next = head;
                    break;
                }

                if (head.val != head.next.val) {
                    tmpHead.next = head;
                    tmpHead = head;
                    tmpHead.next = null;

                }
                head = head.next;

            }

            return newHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}