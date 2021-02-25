package cn.errison.leetcode.structure.tree;

import cn.errison.leetcode.common.definition.TreeNode;
import cn.errison.leetcode.common.util.ListUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * <p>
 * 输入：root = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 5：
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        TreeNode root = TreeNode.genTreeFromList(Arrays.asList(1, null, 2, 3));
//        System.out.println(solution.inorderTraversal(root));
        System.out.println(new BinaryTreeInorderTraversal().new Solution1().inorderTraversal(root));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        /**
         * 递归调用版
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> result = new ArrayList<>();
            inorderTraversal(root, result);
            return result;
        }

        private void inorderTraversal(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }

    }

    class Solution1 {

        /**
         * 利用栈
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}