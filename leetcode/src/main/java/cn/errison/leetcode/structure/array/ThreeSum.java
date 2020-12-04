package main.java.cn.errison.leetcode.structure.array;

import java.util.*;

/**
 * <p>Given an array <code>nums</code> of <em>n</em> integers, are there elements <em>a</em>, <em>b</em>, <em>c</em> in <code>nums</code> such that <em>a</em> + <em>b</em> + <em>c</em> = 0? Find all unique triplets in the array which gives the sum of zero.</p>
 *
 * <p><strong>Note:</strong></p>
 *
 * <p>The solution set must not contain duplicate triplets.</p>
 *
 * <p><strong>Example:</strong></p>
 *
 * <pre>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * </pre>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div>\n<div><li>👍 2513</li><li>👎 0</li></div>
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] array = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum1(array);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 暴力破解
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return new ArrayList<>();
            }
            Set<List<Integer>> result = new HashSet<>();
            Set<List<Integer>> verify = new HashSet<>();
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int m = j + 1; m < nums.length; m++) {
                        if (nums[i] + nums[j] + nums[m] == 0) {
                            List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[m]);
                            Collections.sort(tmp);
                            if (verify.add(tmp)) {
                                result.add(tmp);
                            }
                        }
                    }
                }
            }
            return new ArrayList<>(result);
        }

        public List<List<Integer>> threeSum1(int[] nums) {
            if (nums.length < 3) {
                return new ArrayList<>();
            }
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int m = i + 1;
                int n = nums.length - 1;
                while (m < n) {
                    int tmp = nums[m] + nums[n] + nums[i];
                    if (tmp > 0) {
                        n--;
                        while (m < n && nums[n] == nums[n + 1]) {
                            n--;
                        }
                    } else if (tmp < 0) {
                        m++;
                        while (m < n && nums[m] == nums[m - 1]) {
                            m++;
                        }
                    } else {
                        result.add(Arrays.asList(nums[i], nums[m], nums[n]));
                        m++;
                        n--;
                        while (m < n && nums[m] == nums[m - 1]) {
                            m++;
                        }
                        while (m < n && nums[n] == nums[n + 1]) {
                            n--;
                        }
                    }
                }
            }
            return result;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}