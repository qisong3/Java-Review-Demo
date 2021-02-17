package cn.errison.leetcode.alogrithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        int[] array = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = solution.combinationSum2(array, 8);
        result.stream().forEach(item -> item.stream().forEach(num -> System.out.print(num + "  ")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, 0, new ArrayList<>(), result);
            return result.stream().distinct().collect(Collectors.toList());
        }

        private void dfs(int[] candidates, int target, int index, List<Integer> combine, List<List<Integer>> result) {
            if (target == 0) {
                result.add(new ArrayList<>(combine));
            }

            if (candidates.length == index) {
                return;
            }

            // skip this index
            dfs(candidates, target, index + 1, combine, result);
            // apply if need
            if (target - candidates[index] >= 0) {
                combine.add(candidates[index]);
                dfs(candidates, target - candidates[index], index + 1, combine, result);
                combine.remove(combine.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}