package cn.errison.leetcode.alogrithms.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        solution.fourSum(nums, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums.length < 4) {
                return new ArrayList<>();
            }

            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                    break;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target){
                        break;
                    }

                    int l = j + 1;
                    int r = nums.length - 1;
                    while (l < r){
                        int sum = nums[i] + nums[j] + nums[l] + nums[r];
                        if (sum == target){
                            result.add(Arrays.asList(nums[i],nums[j], nums[r], nums[l]));
                            while(l < r && nums[l] == nums[l+1]){
                                l++;
                            }
                            while(l < r && nums[r] == nums[r-1]){
                                r--;
                            }
                            l++;
                            r--;
                        }else if(sum > target){
                            r--;
                        }else {
                            l++;
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}