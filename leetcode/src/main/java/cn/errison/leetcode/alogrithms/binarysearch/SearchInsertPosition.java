package cn.errison.leetcode.alogrithms.binarysearch;


import java.util.Arrays;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        int[] array = new int[]{1,3,5,6};
        System.out.println(solution.searchInsert(array, 2)); ;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int len = nums.length;
            if (len < 1) {
                return 0;
            }
            if (target < nums[0]) {
                return 0;
            }
            if (target > nums[len - 1]) {
                return len;
            }
            return binarySearch(nums, 0, len - 1, target);
        }

        private int binarySearch(int[] nums, int start, int end, int target) {
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}