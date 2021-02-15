package cn.errison.leetcode.alogrithms.backtracking;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> letterCombinations(String digits) {
            Map<Character, String> phoneMap = new HashMap<Character, String>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};
            List<String> result = new ArrayList<>();
            backtracking(result, phoneMap, digits, 0, new StringBuffer());
            return result;
        }

        private void backtracking(List<String> result, Map<Character, String> phoneMap, String digits, int index, StringBuffer sb) {
            if (index == digits.length()) {
                result.add(sb.toString());
            } else {
                char digit = digits.charAt(index);
                String str = phoneMap.get(digit);
                for (int i = 0; i < str.length(); i++) {
                    sb.append(str.charAt(i));
                    backtracking(result, phoneMap, digits, index + 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}