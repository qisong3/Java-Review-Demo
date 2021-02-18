package cn.errison.leetcode.alogrithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 示例 3：
 * <p>
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * <p>
 * 示例 4：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * <p>
 * 示例 5：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertInterval {
    public static void main(String[] args) {
        Solution solution = new InsertInterval().new Solution();
//        int[][] intervals = new int[][]{{0, 5}, {9, 12}};
//        int[] newInterval = new int[]{7, 16};
//        int[][] intervals = new int[][]{{0, 5}, {9, 12}};
//        int[] newInterval = new int[]{7, 16};
        int[][] intervals = new int[][]{{1, 5}};
        int[] newInterval = new int[]{2, 8};
        int[][] merged = solution.insert(intervals, newInterval);
        for (int[] arr : merged) {
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int len = intervals.length;
            if (len == 0) {
                return new int[][]{{newInterval[0], newInterval[1]}};
            }

            List<int[]> result = new ArrayList<>();
            boolean mergedNew = false;
            int newLeft = newInterval[0];
            int newRight = newInterval[1];
            for (int i = 0; i < len; i++) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                if (!mergedNew) {
                    if (newLeft <= left) {
                        if (result.isEmpty()) {
                            result.add(newInterval);
                        } else {
                            // 合并
                            int lastRight = result.get(result.size() - 1)[1];
                            if (newLeft <= lastRight) {
                                result.get(result.size() - 1)[1] = Math.max(newRight, result.get(result.size() - 1)[1]);
                            } else {
                                result.add(newInterval);
                            }
                        }
                        i--;
                        mergedNew = true;
                    } else {
                        result.add(intervals[i]);
                    }
                } else {
                    // 合并newInternal以后就逐个合并即可
                    if (result.get(result.size() - 1)[1] < left) {
                        result.add(intervals[i]);
                    } else {
                        result.get(result.size() - 1)[1] = Math.max(right, result.get(result.size() - 1)[1]);
                    }
                }
            }

            if (!mergedNew) {
                // 合并
                int lastRight = result.get(result.size() - 1)[1];
                if (newLeft <= lastRight) {
                    result.get(result.size() - 1)[1] = Math.max(newRight, result.get(result.size() - 1)[1]);
                } else {
                    result.add(newInterval);
                }
            }

            return result.toArray(new int[result.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}