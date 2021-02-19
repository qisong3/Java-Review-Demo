package cn.errison.leetcode.structure.array;


import java.sql.ResultSet;
import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
//        int[] digits = new int[]{4, 3, 2, 1};
//        int[] digits = new int[]{9};
//        int[] digits = new int[]{9,9,9,9,9,9,9};
        int[] digits = new int[]{8,9,9,2,9,9,9};
        Arrays.stream(solution.plusOne(digits)).asLongStream().forEach(System.out::print);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] plusOne(int[] digits) {

            int m = digits.length;
            boolean add = false;
            digits[m - 1] += 1;
            if (digits[m-1] >= 10){
                digits[m-1] = digits[m-1] % 10;
                add = true;
            }
            for (int i = m - 2; i >= 0; i--) {
                digits[i] = digits[i] + (add ? 1 : 0);
                if (digits[i] >= 10){
                    digits[i] %= 10;
                    add = true;
                }else {
                    add = false;
                }
            }

            if (!add) {
                return digits;
            } else {
                int[] result = new int[m + 1];
                System.arraycopy(digits, 0, result, 1, m);
                result[0] = 1;
                result[1] = result[1] % 10;
                return result;
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}