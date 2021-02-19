package cn.errison.leetcode.alogrithms.dynamicprograming;


/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
//        System.out.println(solution.climbStairs1(1));
//        System.out.println(solution.climbStairs1(2));
//        System.out.println(solution.climbStairs1(3));
        System.out.println(solution.climbStairs1(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * time limit exceed
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }

        public int climbStairs1(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int result = 0;
            int pre = 2;
            int ppre = 1;
            for (int i = 3; i <= n; i++){
                result = ppre + pre;
                ppre = pre;
                pre = result;
            }
            return result;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}