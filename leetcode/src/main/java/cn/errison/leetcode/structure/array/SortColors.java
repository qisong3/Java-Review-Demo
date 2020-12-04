package main.java.cn.errison.leetcode.structure.array;

import java.util.Arrays;

/**
 * <p>Given an array with <em>n</em> objects colored red, white or blue, sort them <strong><a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a>&nbsp;</strong>so that objects of the same color are adjacent, with the colors in the order red, white and blue.</p>
 *
 * <p>Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.</p>
 *
 * <p><strong>Note:</strong>&nbsp;You are not suppose to use the library&#39;s sort function for this problem.</p>
 *
 * <p><strong>Example:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> [2,0,2,1,1,0]
 * <strong>Output:</strong> [0,0,1,1,2,2]</pre>
 *
 * <p><strong>Follow up:</strong></p>
 *
 * <ul>
 * 	<li>A rather straight forward solution is a two-pass algorithm using counting sort.<br />
 * 	First, iterate the array counting number of 0&#39;s, 1&#39;s, and 2&#39;s, then overwrite array with total number of 0&#39;s, then 1&#39;s and followed by 2&#39;s.</li>
 * 	<li>Could you come up with a&nbsp;one-pass algorithm using only constant space?</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>排序</li><li>数组</li><li>双指针</li></div></div>\n<div><li>👍 564</li><li>👎 0</li></div>
 */
public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
//        solution.sortColors(new int[]{2,0,2,1,1,0});
        solution.sortColors(new int[]{1, 2, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void sortColors(int[] nums) {
            int position0 = 0;
            int position2 = nums.length - 1;
            int tmp;
            for (int cur = 0; cur <= position2; ) {
                if (nums[cur] == 0) {
                    tmp = nums[position0];
                    nums[cur++] = tmp;
                    nums[position0++] = 0;
                } else if (nums[cur] == 2) {
                    tmp = nums[position2];
                    nums[cur] = tmp;
                    nums[position2--] = 2;
                } else {
                    cur++;
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}