package dataStructure.hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class groupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));

    }
        public static List<List<String>> groupAnagrams(String[] strs) {
            //将字母映射成为数字，记录每个数字出现的次数，用数组保存起来，如果是异位字符，数组一定是相同的
            //比如说aaBBCC和aaccBB在数组中都是222
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                String hash = getHash(s);
                if(map.containsKey(hash)) {
                    //取出桶相对用的list
                    List<String> strings = map.get(hash);
                    strings.add(s);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(s);
                    map.put(hash, list);
                }
            }
            return new ArrayList<>(map.values());
        }
        //将每个字母映射成为数组的数字
        public static String getHash(String s) {
            int[] hash = new int[26];
            for (int i = 0; i < s.length(); i++) {
                hash[s.charAt(i) - 'a']++;
            }
            StringBuilder res = new StringBuilder();
            for (int i : hash) {
                res.append("|");
                res.append(i);
            }
            return res.toString();
        }
    //使用stream流进行运算
    public List<List<String>> groupAnagrams1(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
    }


}
