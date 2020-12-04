package cn.errison.leetcode.structure.list;

import cn.errison.leetcode.structure.definition.ListNode;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListII().new Solution();
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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == n){
                return head;
            }
            ListNode newHead = new ListNode(-1);
            newHead.next = head;
            int num = 0;
            while (head.next != null) {

                head = head.next;
                num++;
            }
            return newHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}