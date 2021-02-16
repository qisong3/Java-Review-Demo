package cn.errison.leetcode.structure.array;


import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * <p>
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
//        int[] array = new int[]{5,6,3,3,3};
        int[] array = new int[]{1,2,3};
//        int[] array = new int[]{3,2,1};
        solution.nextPermutation(array);
        Arrays.stream(array).forEach(System.out::print);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            int index = len - 2;
            while (index > 0 && nums[index] >= nums[index + 1]) {
                index--;
            }

            if (index >= 0) {
                int j = len - 1;
                while (j > 0 && nums[index] >= nums[j]) {
                    j--;
                }
                swap(nums, index, j);
            }
            reverse(nums, index + 1, len - 1);
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        private void reverse(int[] nums, int i, int j) {
            while (i < j) {
                swap(nums, i++, j--);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}