package cn.errison.leetcode.structure.string;


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

    class Solution2{
        public String longestPalindrome(String s) {

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}