package cn.errison.leetcode.alogrithms.twopointers;

import cn.errison.leetcode.common.util.ArrayUtils;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = new int[] { 1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};
        solution.merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
        ArrayUtils.print(nums1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {

            int i = 0, j = 0, k = 0;
            while (i < m && j < n) {
                if (nums1[m - 1 - i] >= nums2[n - 1 - j]) {
                    nums1[m + n - 1 - k] = nums1[m - 1 - i];
                    i++;
                } else {
                    nums1[m + n - 1 - k] = nums2[n - 1 - j];
                    j++;
                }
                k++;
            }

            while (i < m) {
                nums1[m + n - 1 - k] = nums1[m - 1 - i];
                i++;
                k++;
            }

            while (j < n) {
                nums1[m + n - 1 - k] = nums2[n - 1 - j];
                j++;
                k++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}