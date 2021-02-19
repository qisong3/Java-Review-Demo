package cn.errison.leetcode.alogrithms.dynamicprograming;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
//        int[][] grid = new int[][]{{0,1},{0,0}};
//        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(solution.minPathSum(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[][] result = new int[m][n];
            result[0][0] = grid[0][0];
            for (int i = 1; i < m; i++) {
                result[i][0] = result[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < n; i++) {
                result[0][i] = result[0][i - 1] + grid[0][i];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    result[i][j] = grid[i][j] + Math.min(result[i - 1][j], result[i][j - 1]);
                }
            }

            return result[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}