package dataStructure.hash;

import java.util.HashMap;

/**
 * 有效的字母异位
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 */
public class isAnagram {

    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Integer i: hashMap.values()
             ) {
            if (i != 0){
                return false;
            }
        }
        return true;

    }

}
