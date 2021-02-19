package cn.errison.leetcode.alogrithms.binarysearch;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(solution.searchMatrix(matrix, 6));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
                return false;
            }

            int[] rowFirst = new int[m];
            // 确定行
            for (int i = 0; i < m; i++) {
                rowFirst[i] = matrix[i][0];
            }
            int row = foundInArray(rowFirst, target);

            int column = foundInArray(matrix[row], target);
            return matrix[row][column] == target;

        }

        private int foundInArray(int[] array, int target) {
            int n = array.length;
            int start = 0, end = n - 1;
            int pos = -1;
            while (start <= end) {
                int mid = (start + end) >> 1;
                if (target == array[mid]) {
                    pos = mid;
                    break;
                } else if (target < array[mid]) {
                    end = mid - 1;
                } else {
                    pos = mid;
                    start = mid + 1;
                }
            }
            return pos;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}