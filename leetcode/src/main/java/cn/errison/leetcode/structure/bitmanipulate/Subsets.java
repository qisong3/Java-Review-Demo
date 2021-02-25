package cn.errison.leetcode.structure.bitmanipulate;

import cn.errison.leetcode.common.util.ListUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] nums = new int[]{1, 2, 3};
        ListUtils.print(solution.subsets(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> subsets(int[] nums) {


            List<List<Integer>> result = new ArrayList<>();
            int n = nums.length;
            int maskNum = 0;
            int max = 2 << (n - 1);
            List<Integer> tmp;
            while (maskNum < max) {
                // 解析成二进制数组，通过判断各个位是否存在值来判断是否需要该位置数组的元素
                String mask = Integer.toBinaryString(maskNum);
                System.out.println(mask);
                tmp = new ArrayList<>();
                int maskLen = mask.length();
                for (int i = maskLen - 1; i >= 0; i--) {
                    if (mask.charAt(i) == '1') {
                        tmp.add(nums[maskLen - 1 - i]);
                    }
                }
                result.add(tmp);
                maskNum++;
            }
            return result;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}