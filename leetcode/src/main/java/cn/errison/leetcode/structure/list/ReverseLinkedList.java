package cn.errison.leetcode.structure.list;

import cn.errison.leetcode.structure.definition.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode list = ListNode.genList(new int[]{2, 4, 3});
        ListNode.print(list);

        ListNode reversed = solution.reverseList(list);
        ListNode.print(reversed);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
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
//leetcode submit region end(Prohibit modification and deletion)

}