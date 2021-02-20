package cn.errison.leetcode.alogrithms.backtracking;


import cn.errison.leetcode.common.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        List<List<Integer>> result = solution.combine(4, 2);
        ListUtils.print(result);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> combination = new ArrayList<>();
            dfs(n, k, 1, combination, result);
            return result;
        }

        private void dfs(int n, int k, int cur, List<Integer> combination, List<List<Integer>> result) {

            if (combination.size() + (n - cur + 1) < k){
                return;
            }

            if (combination.size() == k) {
                result.add(new ArrayList<>(combination));
                return;
            }


            combination.add(cur);
            System.out.println("回溯前" + combination);
            dfs(n, k, cur + 1, combination, result);
            combination.remove(combination.size() - 1);
            System.out.println("回溯后" + combination);

            dfs(n, k, cur + 1, combination, result);
        }


//leetcode submit region end(Prohibit modification and deletion)

    }
}