package cn.errison.leetcode.alogrithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        int[] array = new int[]{ 2,3,6,7};
        List<List<Integer>> result = solution.combinationSum(array, 7);
        result.stream().forEach(item -> item.stream().forEach(System.out::print));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList<>();
            dfs(candidates, target, 0, new ArrayList<Integer>(), result);
            return result;
        }

        private void dfs(int[] candidates, int target, int index, List<Integer> combine, List<List<Integer>> result) {
            if (index == candidates.length) {
                return;
            }
            if (target == 0) {
                result.add(new ArrayList<>(combine));
            }

            dfs(candidates, target, index + 1, combine, result);

            if (target - candidates[index] >= 0) {
                combine.add(candidates[index]);
                dfs(candidates, target - candidates[index], index, combine, result);
                combine.remove(combine.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}