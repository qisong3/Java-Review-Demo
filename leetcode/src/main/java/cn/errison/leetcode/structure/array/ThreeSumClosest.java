package main.java.cn.errison.leetcode.structure.array;

import java.util.Arrays;
import java.util.Optional;

/**
 * <p>Given an array <code>nums</code> of <em>n</em> integers and an integer <code>target</code>, find three integers in <code>nums</code>&nbsp;such that the sum is closest to&nbsp;<code>target</code>. Return the sum of the three integers. You may assume that each input would have exactly one solution.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [-1,2,1,-4], target = 1
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>3 &lt;= nums.length &lt;= 10^3</code></li>
 * 	<li><code>-10^3&nbsp;&lt;= nums[i]&nbsp;&lt;= 10^3</code></li>
 * 	<li><code>-10^4&nbsp;&lt;= target&nbsp;&lt;= 10^4</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div>\n<div><li>👍 553</li><li>👎 0</li></div>
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
//        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
//        System.out.println(solution.threeSumClosest(new int[]{0, 1, 2}, 3));
//        System.out.println(solution.threeSumClosest(new int[]{ -100,-98,-2,-1}, -101));
//        System.out.println(solution.threeSumClosest(new int[]{ 56,57,-47,-14,23,31,20,39,-51,7,-4,43,-53,32,24,56,-28,90,-75,-6,21,-100,41,-84,95,95,44,84,70,-22,-86,-6,90,-87,65,-28,-29,-94,98,-28,-100,23,-25,6,-56,-54,-5,53,-88,-25,-31,-71,-13,-62,73,-35,-78,16,99,97,84,-27,-43,-50,18,-16,-61,7,-17,16,-92,28,43,-38,-33,-27,84,-72,-100,-91,-97,-99,59,-63,73,99,98,-100,-37,-80,3,18,93,-81,12,-75,-43,99,10,10,-6,13,0,76,-82,-5,27,-38,-81,77,-55,-100,90,-32,-25,-15,-16,68,-6,87,65,-38,82,78,-61,87,-72,46,50,-60,86,39,69,85,-49,28}, -289));
//        System.out.println(solution.threeSumClosest1(new int[]{56, 57, -47, -14, 23, 31, 20, 39, -51, 7, -4, 43, -53, 32, 24, 56, -28, 90, -75, -6, 21, -100, 41, -84, 95, 95, 44, 84, 70, -22, -86, -6, 90, -87, 65, -28, -29, -94, 98, -28, -100, 23, -25, 6, -56, -54, -5, 53, -88, -25, -31, -71, -13, -62, 73, -35, -78, 16, 99, 97, 84, -27, -43, -50, 18, -16, -61, 7, -17, 16, -92, 28, 43, -38, -33, -27, 84, -72, -100, -91, -97, -99, 59, -63, 73, 99, 98, -100, -37, -80, 3, 18, 93, -81, 12, -75, -43, 99, 10, 10, -6, 13, 0, 76, -82, -5, 27, -38, -81, 77, -55, -100, 90, -32, -25, -15, -16, 68, -6, 87, 65, -38, 82, 78, -61, 87, -72, 46, 50, -60, 86, 39, 69, 85, -49, 28}, -289));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int closest = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int m = i + 1;
                int n = nums.length - 1;
                while (m < n) {
                    int tmp = nums[i] + nums[m] + nums[n];
                    if (tmp == target) {
                        return target;
                    } else if (tmp > target) {
                        closest = Math.abs(tmp - target) < Math.abs(closest - target) ? tmp : closest;
                        n--;
                        while (m < n && nums[n] == nums[n + 1]) {
                            n--;
                        }
                    } else {
                        closest = Math.abs(tmp - target) < Math.abs(closest - target) ? tmp : closest;
                        m++;
                        while (m < n && nums[m] == nums[m - 1]) {
                            m++;
                        }
                    }
                }
            }
            return closest;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}