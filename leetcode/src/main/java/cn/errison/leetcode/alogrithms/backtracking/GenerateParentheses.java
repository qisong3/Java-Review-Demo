package cn.errison.leetcode.alogrithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        List<String> result = solution.generateParenthesis(3);
        result.stream().forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            dfs(result, new StringBuilder("("), 1, 0, n);
            return result;
        }

        private void dfs(List<String> result, StringBuilder sb, int left, int right, int n) {
            if (sb.length() == 2 * n) {
                result.add(sb.toString());
                return;
            }

            if (left < n) {
                sb.append("(");
                dfs(result, sb, left + 1, right, n);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (left > right) {
                sb.append(")");
                dfs(result, sb, left, right + 1, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}