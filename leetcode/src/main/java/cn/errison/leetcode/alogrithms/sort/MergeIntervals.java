package cn.errison.leetcode.alogrithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
//        int[][] array = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] array = new int[][]{{1, 4}, {1, 3}};
        int[][] merged = solution.merge(array);
        Arrays.stream(merged).forEach(System.out::print);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            int len = intervals.length;
            if (len == 1) {
                return intervals;
            }

            Arrays.sort(intervals, comparator);
            List<int[]> result = new ArrayList<>();
            for (int i = 0; i < len ; i++) {
                int left = intervals[i][0];
                int right = intervals[i][1];

                // 不需要合并
                if (i == 0 || result.get(result.size() -1)[1] < left){
                    result.add(intervals[i]);
                }else {
                    result.get(result.size() - 1)[1] = Math.max(right, result.get(result.size() -1)[1]);
                }
            }

            int[][] merged = new int[result.size()][2];
            for (int i = 0; i < result.size(); i++) {
                merged[i] = result.get(i);
            }
            return merged;
        }

        private final Comparator<int[]> comparator = (array1, array2) -> array1[0] < array2[0] ? -1 : (array1[0] > array2[0] ? 1 : 0);
    }
//leetcode submit region end(Prohibit modification and deletion)

}