package cn.errison.leetcode.structure.array;


import cn.errison.leetcode.common.ArrayUtils;

import java.util.Arrays;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 进阶:
 *
 *     一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 *     一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 *     你能想出一个常数空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new SetMatrixZeroes().new Solution();
        int[][] matrix = new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        solution.setZeroes(matrix);
        ArrayUtils.print(matrix);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {

        if (matrix == null){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] zeros = new int[m + n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    zeros[i] = 1;
                    zeros[m + n - 1 - j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (zeros[i] == 1){
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int i = 0; i < n; i++){
            if (zeros[m + n - 1 - i] == 1){
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}