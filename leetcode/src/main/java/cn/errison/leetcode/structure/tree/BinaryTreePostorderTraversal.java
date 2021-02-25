package cn.errison.leetcode.structure.tree;

import cn.errison.leetcode.common.definition.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
        TreeNode root = TreeNode.genTreeFromList(Arrays.asList(1, null, 2, 3));
        System.out.println(solution.postorderTraversal(root));
        Solution1 solution1 = new BinaryTreePostorderTraversal().new Solution1();
        System.out.println(solution1.postorderTraversal(root));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            postorderTraversal(root, result);
            return result;
        }

        private void postorderTraversal(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            postorderTraversal(root.left, result);
            postorderTraversal(root.right, result);
            result.add(root.val);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            while (!stack.isEmpty() || root != null) {
                // 依次放入左子树
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();

                // 没有右子树说明是左下角的叶子节点左子树，直接输出
                // 或者是上一个输出的是自己的右子节点的，则说明左右子节点都已弹出，可以直接输出
                if (root.right == null || root.right == pre) {
                    result.add(root.val);
                    pre = root;
                    root = null;
                }else {
                    stack.push(root);
                    root = root.right;
                }

            }

            return result;
        }
    }
}