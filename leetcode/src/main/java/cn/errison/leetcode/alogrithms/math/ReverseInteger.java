package cn.errison.leetcode.alogrithms.math;

/**
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse(Integer.MAX_VALUE));
        System.out.println(solution.reverse(-123));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        boolean negative = x < 0;
        if (negative){
            x = -x;
        }
        String str = Integer.toString(x);
        int right = str.length() - 1;
        int num = 0, index = 0;
        while (right > - 1){
            if (num > Integer.MAX_VALUE / 10){
                return 0;
            }
            int bit = str.charAt(right) - '0';
            num = 10 * num + bit;
            right --;
        }
        return negative? -num: num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}