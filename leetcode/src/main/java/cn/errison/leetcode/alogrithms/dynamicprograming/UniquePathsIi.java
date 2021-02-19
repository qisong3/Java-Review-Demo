package cn.errison.leetcode.alogrithms.dynamicprograming;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 示例 2：
 * <p>
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
//        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
//        int[][] obstacleGrid = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
//        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 1}};
//        int[][] obstacleGrid = new int[][]{{0,1,0}};
//        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,1},{0,1,0}};
        int[][] obstacleGrid = new int[][]{{0,1},{0,0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
                return 0;
            }

            int[][] result = new int[m][n];
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] != 1) {
                    result[i][0] = 1;
                } else {
                    while (i < m) {
                        result[i][0] = 0;
                        i++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (obstacleGrid[0][i] != 1) {
                    result[0][i] = 1;
                } else {
                    while (i < n) {
                        result[0][i] = 0;
                        i++;
                    }
                }

            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        result[i][j] = 0;
                    } else {
                        result[i][j] = result[i - 1][j] + result[i][j - 1];
                    }
                }
            }

            return result[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}