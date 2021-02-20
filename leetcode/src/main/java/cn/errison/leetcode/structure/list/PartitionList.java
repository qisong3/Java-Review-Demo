package cn.errison.leetcode.structure.list;


import cn.errison.leetcode.common.ListNode;

import java.util.List;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
//        ListNode head = ListNode.genList(new int[]{1,4,3,2,5,2});
//        head = solution.partition(head, 3);
        ListNode head = ListNode.genList(new int[]{1,1});
        head = solution.partition(head, 3);
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

        public ListNode partition(ListNode head, int x) {
            ListNode smallHead = new ListNode(-1);
            ListNode smallTail = smallHead;

            ListNode bigHead = new ListNode(-1);
            ListNode bigTail = bigHead;
            ListNode tmp;
            while (head != null) {
                if (head.val < x) {
                    tmp = head.next;
                    smallTail.next = head;
                    smallTail = head;
                } else {
                    tmp = head.next;
                    bigTail.next = head;
                    bigTail = head;
                }
                head.next = null;
                head = tmp;
            }
            smallTail.next = bigHead.next;
            return smallHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}