package cn.errison.leetcode.structure.list;

import cn.errison.leetcode.common.definition.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        ListNode head = ListNode.genList(new int[] {1,1,2,3,3});
        head = solution.deleteDuplicates(head);
        ListNode.print(head);
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
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = new ListNode(-1, head);
        int pre = head.val;
        while (head.next != null){
            // 前一个节点等于后一个节点，则前一个节点指向后一个节点的后一个
            if (pre == head.next.val){
                head.next = head.next.next;
                continue;
            }
            head = head.next;
            pre = head.val;
        }

        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}