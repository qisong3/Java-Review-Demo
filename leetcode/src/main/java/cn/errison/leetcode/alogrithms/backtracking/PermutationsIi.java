package cn.errison.leetcode.alogrithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] array = new int[]{1, 1, 2};
        List<List<Integer>> result = solution.permuteUnique(array);
        result.stream().forEach(System.out::print);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> permuteUnique(int[] nums) {
            int len = nums.length;
            List<List<Integer>> result = new ArrayList<>();
            boolean[] usage = new boolean[len];
            Arrays.sort(nums);
            dfs(nums, 0, usage, new ArrayList<>(), result);
            return result;
        }

        private void dfs(int[] nums, int depth, boolean[] usage, List<Integer> combine, List<List<Integer>> result) {

            if (nums.length == depth) {
                result.add(new ArrayList<>(combine));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (usage[i] || i > 0 && nums[i] == nums[i - 1] && !usage[i - 1]) {
                    continue;
                }

                combine.add(nums[i]);

                usage[i] = true;
                dfs(nums, depth + 1, usage, combine, result);

                usage[i] = false;
                combine.remove(combine.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}