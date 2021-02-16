package cn.errison.leetcode.alogrithms.binarysearch;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
//        int[] array = new int[]{5, 7, 7, 8, 8, 10};
//        int[] result = solution.searchRange(array, 8);
        int[] array = new int[]{1, 1, 1, 1, 1};
        int[] result = solution.searchRange(array, 0);
        Arrays.stream(result).forEach(System.out::print);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int originIndex = binarySearch(nums, 0, nums.length - 1, target);
            if (originIndex == -1) {
                return new int[]{-1, -1};
            }
            int first = binarySearchFirst(nums, 0, originIndex, target);
            int end = binarySearchEnd(nums, originIndex, nums.length - 1, target);
            return new int[]{first, end};
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
            return -1;
        }


        /**
         * 搜索首个
         *
         * @param nums
         * @param start
         * @param end
         * @param target
         * @return
         */
        private int binarySearchFirst(int[] nums, int start, int end, int target) {
            int first = end;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] == target) {
                    first = mid < first ? mid : first;
                    end = mid - 1;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return first;
        }

        /**
         * 搜索最后一个
         *
         * @param nums
         * @param start
         * @param end
         * @param target
         * @return
         */
        private int binarySearchEnd(int[] nums, int start, int end, int target) {
            int last = start;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] == target) {
                    last = mid > last ? mid : last;
                    start = mid + 1;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}