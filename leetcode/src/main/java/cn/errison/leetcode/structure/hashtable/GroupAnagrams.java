package cn.errison.leetcode.structure.hashtable;

import java.lang.annotation.Retention;
import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明：
 *
 *     所有输入均为小写字母。
 *     不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strings));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String string: strs){
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                list.add(string);
                map.put(key, list);
            }else {
                map.get(key).add(string);
            }
        }
        for(List<String> value : map.values()){
            result.add(value);
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}