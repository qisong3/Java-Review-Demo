package main.java.cn.errison.leetcode.structure.hashtable;

import java.util.Arrays;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring1("tmmzuxt"));
        System.out.println(solution.lengthOfLongestSubstring1("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring1("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring1("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring1("au"));
        System.out.println(solution.lengthOfLongestSubstring1("a"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 滑动窗口
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            if (s.length() < 2) {
                return s.length();
            }
            int[] table = new int[128];
            Arrays.fill(table, -1);
            int max = 1;
            int curMax = 1;
            int winStart = 0;
            int winEnd;
            for (winEnd = 0; winEnd < s.length(); winEnd++) {
                if (table[s.charAt(winEnd)] == -1) {
                    curMax = winEnd - winStart + 1;
                } else {
                    curMax = winEnd - winStart;
                    int prevPos = table[s.charAt(winEnd)];
                    for (int j = winStart; j <= prevPos; j++) {
                        table[s.charAt(j)] = -1;
                    }
                    winStart = prevPos + 1;
                }
                table[s.charAt(winEnd)] = winEnd;
                max = Math.max(max, curMax);
            }
            return max;
        }

        /**
         * 滑动窗口优化
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring1(String s) {
            if (s.length() < 2) {
                return s.length();
            }
            int[] table = new int[128];
            Arrays.fill(table, -1);
            int max = 1;
            int winStart = 0;
            for (int winEnd = 0; winEnd < s.length(); winEnd++) {
                char ch = s.charAt(winEnd);
                if (table[ch] != -1) {
                    winStart = Math.max(table[ch] + 1, winStart);
                }
                max = Math.max(winEnd - winStart + 1, max);
                table[ch] = winEnd;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}