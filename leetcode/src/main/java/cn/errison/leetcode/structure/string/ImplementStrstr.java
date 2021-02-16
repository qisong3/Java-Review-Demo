package cn.errison.leetcode.structure.string;

public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        System.out.println(solution.strStr("aaab", "ab"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        for (int i = 0; i < hLen - nLen + 1; i++){
            if (haystack.substring(i, i + nLen).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}