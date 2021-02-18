package cn.errison.leetcode.structure.string;

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = " "
 * 输出：0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
//        System.out.println(solution.lengthOfLastWord("       "));
//        System.out.println(solution.lengthOfLastWord(" a bb ccc d"));
        System.out.println(solution.lengthOfLastWord(" "));
//        System.out.println(solution.lengthOfLastWord("World"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            int n = s.length() - 1;
            // 跳过末尾的空格
            while (n >= 0) {
                if (s.charAt(n) != ' ') {
                    break;
                }
                if (n == 0 && s.charAt(n) == ' ') {
                    return 0;
                }
                n--;
            }

            // 计算长度
            int end = n, start = n;
            while (n >= 0) {
                if (s.charAt(n) == ' ') {
                    start = n + 1;
                    break;
                }

                if (n == 0){
                    start = 0;
                }
                n--;
            }

            return end - start + 1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}