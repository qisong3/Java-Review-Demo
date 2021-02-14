package cn.errison.leetcode.structure.string;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 1000
 *     s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution1 solution = new LongestPalindromicSubstring().new Solution1();
        System.out.println(solution.longestPalindrome("bb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {

        /**
         * time exceed
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }
            int maxLen = 1;
            String maxString = s.substring(0, 1);
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    String sub = s.substring(i, j + 1);
                    if (isPalindrome(sub)) {
                        int tmpLen = sub.length();
                        if (tmpLen > maxLen) {
                            maxLen = tmpLen;
                            maxString = sub;
                        }
                    }
                }
            }
            return maxString;
        }

        private boolean isPalindrome(String s) {
            int len = s.length();
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}