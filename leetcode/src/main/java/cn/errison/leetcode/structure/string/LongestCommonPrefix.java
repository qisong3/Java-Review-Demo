package cn.errison.leetcode.structure.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strings = new String[]{"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strings));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefixIn2Strings(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefixIn2Strings(String str1, String str2){
        if (str1.isEmpty() || str2.isEmpty()){
            return "";
        }
        int i = 0;
        while (i < str1.length() && i < str2.length()){
            if (str1.charAt(i) == str2.charAt(i)){
                i++;
            }else {
                break;
            }
        }
        return str1.substring(0, i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}