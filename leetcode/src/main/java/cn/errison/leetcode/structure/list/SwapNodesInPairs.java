package cn.errison.leetcode.structure.list;

import cn.errison.leetcode.common.definition.ListNode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        ListNode list = ListNode.genList(new int[]{1,2,3,4,5});
        ListNode node = solution.swapPairs(list);
        ListNode.print(node);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1, head);
        ListNode newTail = newHead;
        ListNode tmp1, tmp2;
        while (newTail.next != null && newTail.next.next != null){
            tmp1 = newTail.next;
            tmp2 = newTail.next.next;
            newTail.next = tmp2;
            tmp1.next = tmp2.next;
            tmp2.next = tmp1;
            newTail = tmp1;
        }
        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}