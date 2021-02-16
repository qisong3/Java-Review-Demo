package cn.errison.leetcode.alogrithms.binarysearch;


/**
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 * <p>
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
//        int[] array = new int[]{5, 6, 7, 1, 2, 3, 4};
//        System.out.println(solution.search(array, 5));
//        System.out.println(solution.search(array, 6));
//        System.out.println(solution.search(array, 7));
//        System.out.println(solution.search(array, 1));
//        System.out.println(solution.search(array, 2));
//        System.out.println(solution.search(array, 3));
//
        int[] array = new int[]{3, 1};
        System.out.println(solution.search(array, 1));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;

            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[l] <= nums[mid]) {
                    if (nums[l] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = r - 1;
                    }
                }
            }

            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}