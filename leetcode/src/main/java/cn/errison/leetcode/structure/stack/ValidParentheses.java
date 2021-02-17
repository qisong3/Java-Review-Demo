package cn.errison.leetcode.structure.stack;


import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 104
 *     s 仅由括号 '()[]{}' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("){"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c){
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if(stack.empty() || stack.peek() != '{'){
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if(stack.empty() || stack.peek() != '['){
                        return false;
                    }
                    stack.pop();
                    break;
                case ')':
                    if(stack.empty() || (stack.peek() != '(')){
                        return false;
                    }
                    stack.pop();
                    break;
            }

        }
        return stack.empty();


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}