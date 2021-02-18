package cn.errison.leetcode.structure.list;

import cn.errison.leetcode.structure.definition.ListNode;


/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateList {
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
//        ListNode node = ListNode.genList(new int[]{1,2,3,4,5});
//        ListNode rotated = solution.rotateRight(node, 2);
//        ListNode node = ListNode.genList(new int[]{1,2,3,4,5});
//        ListNode rotated = solution.rotateRight(node, 5);
//        ListNode node = ListNode.genList(new int[]{1});
//        ListNode rotated = solution.rotateRight(node, 2);
        ListNode node = ListNode.genList(new int[]{1,2,3,4,5});
        ListNode rotated = solution.rotateRight(node, 201);
        ListNode.print(rotated);
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k ==  0){
            return head;
        }
        int len = 1;
        ListNode newHead = new ListNode(-1, head);
        ListNode oriTail = null;
        while (head != null){
            if (head.next == null){
                oriTail = head;
                break;
            }
            head = head.next;
            len++;
        }

        k = k % len;
        if (k == 0){
            return newHead.next;
        }
        k = len - k;
        ListNode tmpHead = newHead;
        head = newHead.next;
        while (k > 0){
            tmpHead = tmpHead.next;
            k--;
        }
        newHead.next = tmpHead.next;
        tmpHead.next = null;
        oriTail.next = head;
        return newHead.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}