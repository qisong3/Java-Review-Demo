package cn.errison.leetcode.structure.list;

import cn.errison.leetcode.common.definition.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null ){
            return head;
        }
        ListNode newHead = new ListNode(-1, head);
        ListNode fast = newHead;
        ListNode low = newHead;
        while (fast != null && n > 0){
            fast = fast.next;
            n--;
            // 不符合条件的列表
            if (fast == null && n > 0){
                return newHead.next;
            }
        }
        while (fast.next != null){
            fast = fast.next;
            low = low.next;
        }
        ListNode deleted = low.next;
        low.next = deleted.next;
        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}