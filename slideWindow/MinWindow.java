package dataStructure.slideWindow;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        //用两个hashmap来记录需要的字符串的个数记录，一个用来记录滑动窗口中的个数
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        //记录子字符串中的字符数
        for (char c: t.toCharArray()) {
            //如果不存在就将初始值设为0
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        //满足最小字串的字符个数，当个数与need长度相同，代表包括字串了
        int vaild = 0;
        //滑动窗口的左右边界
        int left = 0, right = 0;
        //最小字符串的边界值，这里用最大值作为默认
        int start = 0, len = Integer.MAX_VALUE;
        while(right < s.length()){
            char c = s.charAt(right);
            right ++;
            //是否包含子字符串的字符
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                //判断个数是否符合
                if (window.get(c).equals(need.get(c))){
                    vaild ++;
                }
            }
            //如果计数相同说明窗口中包含了全部的子字符串,开缩小滑动窗口，直到最后
            //注意这里是while不是if，在有子字符串的时候不断缩小
            while (vaild == need.size()){
                //记录最小字符串的左右边界
                if ((right - left) < len){
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                //开始对窗口进行缩小处理
                left ++;
                //剔除相对应的字符
                if (need.containsKey(d)){
                    //如果包含子字符串的字符
                    if (window.get(d).equals(need.get(d))){
                        vaild -- ;
                    }
                    //更新win的字符记录
                    window.put(d, window.get(d) - 1);
                }
            }

        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }
}
