package cn.errison.leetcode.alogrithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class NQueens {
    public static void main(String[] args) {
        Solution1 solution = new NQueens().new Solution1();
        System.out.println(solution.solveNQueens(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            int[][] board = new int[n][n];
            dfs(board, n, 0, result);
            return result;
        }

        private void dfs(int[][] board, int n, int row, List<List<String>> result) {
            if (row == n) {
                result.add(generateResult(board, n));
                return;
            }

            for (int i = 0; i < n; i++) {
                if (!checkValid(board, n, row, i)) {
                    continue;
                }
                board[row][i] = 1;
                dfs(board, n, row + 1, result);
                board[row][i] = 0;
            }
        }

        private boolean checkValid(int[][] board, int n, int row, int column) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        if (j == column || (row - i) == Math.abs(column - j)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        private List<String> generateResult(int[][] board, int n) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        builder.append("Q");
                    } else {
                        builder.append(".");
                    }
                }
                result.add(builder.toString());
            }
            return result;
        }


    }

    class Solution1 {

        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i],'.');
            }
            dfs(board, n, 0, result);
            return result;
        }

        private void dfs(char[][] board, int n, int row, List<List<String>> result) {
            if (row == n) {
                result.add(generateResult(board));
                return;
            }

            for (int i = 0; i < n; i++) {
                if (!checkValid(board, n, row, i)) {
                    continue;
                }
                board[row][i] = 'Q';
                dfs(board, n, row + 1, result);
                board[row][i] = '.';
            }
        }

        private boolean checkValid(char[][] board, int n, int row, int column) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'Q') {
                        if (j == column || (row - i) == Math.abs(column - j)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        private List<String> generateResult(char[][] board) {
            List<String> result = new ArrayList<>();
            for (char[] chars : board) {
                result.add(new String(chars));
            }
            return result;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}