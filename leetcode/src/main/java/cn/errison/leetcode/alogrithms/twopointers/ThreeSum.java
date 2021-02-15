package cn.errison.leetcode.alogrithms.twopointers;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
//        int[] nums = new int[]{-1, 0, 1, 0, 0, 0, 0, 2, -1, -4};
        int[] nums = new int[]{-2,0,1,1,2};
        solution.threeSum(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) {
                return new ArrayList<>();
            }
            HashSet<List<Integer>> result = new HashSet<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int base = nums[i];
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    if (base + nums[j] + nums[k] > 0) {
                        k--;
                    } else if (base + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
                        result.add(Arrays.asList(base, nums[j], nums[k]));
                        j++;
                        k--;
                    }
                }
            }
            return new ArrayList<>(result);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}