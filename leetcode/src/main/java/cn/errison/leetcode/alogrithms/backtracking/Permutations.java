package cn.errison.leetcode.alogrithms.backtracking;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] array = new int[]{1, 2, 3};
        List<List<Integer>> result = solution.permute(array);
        result.stream().forEach(System.out::print);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            List<List<Integer>> result = new ArrayList<>();
            boolean[] usage = new boolean[len];
            dfs(nums, 0, usage, new ArrayList<>(), result);
            return result;
        }

        private void dfs(int[] nums, int depth, boolean[] usage, List<Integer> combine, List<List<Integer>> result) {

            if (nums.length == depth) {
                result.add(new ArrayList<>(combine));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!usage[i]) {
                    combine.add(nums[i]);

                    usage[i] = true;
                    dfs(nums, depth + 1, usage, combine, result);

                    usage[i] = false;
                    combine.remove(combine.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}