package cn.errison.leetcode.structure.list;

import cn.errison.leetcode.common.definition.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 *
 *
 * 提示：
 *
 *     两个链表的节点数目范围是 [0, 50]
 *     -100 <= Node.val <= 100
 *     l1 和 l2 均按 非递减顺序 排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode l1 = ListNode.genList(new int[]{1,1,2,3});
        ListNode l2  = ListNode.genList(new int[]{2,3,4});
        ListNode result = solution.mergeTwoLists(l1, l2);
        ListNode.print(result);
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        ListNode tmp ;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                tmp = l1;
                l1 = l1.next;
            }else {
                tmp = l2;
                l2 = l2.next;
            }
            tmp.next = null;
            tail.next = tmp;
            tail = tmp;
        }
        if (l1 != null){
            tail.next = l1;
        }
        if (l2 != null){
            tail.next = l2;
        }
        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}