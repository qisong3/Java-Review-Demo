package cn.errison.leetcode.alogrithms.dynamicprograming;


/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        int[] array = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(array));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            if (n < 1) {
                return 0;
            }
            int[] leftMax = new int[n];
            int[] rightMax = new int[n];

            leftMax[0] = height[0];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            rightMax[n - 1] = height[n - 1];
            for (int i = n - 2; i > -1; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                result += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}