package main.java.cn.errison.leetcode.structure.array;

/**
 * <p>Given <i>n</i> non-negative integers <i>a<sub>1</sub></i>, <i>a<sub>2</sub></i>, ..., <i>a<sub>n&nbsp;</sub></i>, where each represents a point at coordinate (<i>i</i>, <i>a<sub>i</sub></i>). <i>n</i> vertical lines are drawn such that the two endpoints of line <i>i</i> is at (<i>i</i>, <i>a<sub>i</sub></i>) and (<i>i</i>, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.</p>
 *
 * <p><strong>Note:&nbsp;</strong>You may not slant the container and <i>n</i> is at least 2.</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" style="width: 600px; height: 287px;" /></p>
 *
 * <p><small>The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain&nbsp;is 49. </small></p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>Example:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> [1,8,6,2,5,4,8,3,7]
 * <strong>Output:</strong> 49</pre><div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div>\n<div><li>👍 1781</li><li>👎 0</li></div>
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int max = 0;
            int leftMax = height[left];
            int rightMax = height[right];
            while (left < right) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                }
                if (height[right] > rightMax) {
                    rightMax = height[right];
                }
                max = Math.max(max, (right - left) * Math.min(leftMax, rightMax));
                if (leftMax < rightMax) {
                    left++;
                } else {
                    right--;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}