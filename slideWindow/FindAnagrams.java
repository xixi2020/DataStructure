package dataStructure.slideWindow;

import dataStructure.tree.binaryTree.MaxDepth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        //用来维护滑动窗口的map
        Map<Character, Integer> windows = new HashMap<Character, Integer>();
        //用来记录需要出现字符个数
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c,0) + 1 );
        }
        //滑动窗口的边界
        int left = 0,right = 0;
        //记录need满足的个数
        int  count = 0;
        //记录结果
        List<Integer> res = new ArrayList<>();

        //开始进行滑动窗口
        while(right < s.length()){
            char d = s.charAt(right);
            right ++;
            if (need.containsKey(d)) {
                windows.put(d, windows.getOrDefault(d, 0) + 1);
                //记录出现了几次重复字符
                //这里防止Integer类型范围溢出要用equals进行对比,Map中存放的value的类型是Integer
                //缓存区的区间范围是[-128, 127]，就不可以用 == 判断了
                if (need.get(d).equals(windows.get(d))) {
                    count++;
                }
            }
            //判断窗口是否需要收缩
            while (right - left >= p.length()){
                //如果need的键值对对个数个count相同
                if ( need.size() == count){
                    //记录满足异位的字符串下标值
                    res.add(left);
                }
                //缩小滑动窗口
                char e = s.charAt(left);
                left ++;
                //滑动窗口更新：如果最左边的一个字符刚好存在子串里，计数减一
                if (need.containsKey(e)){
                    //这里防止Integer类型范围溢出要用equals进行对比,Map中存放的value的类型是Integer
                    //缓存区的区间范围是[-128, 127]，就不可以用 == 判断了
                    //if (windows.get(e) == need.get(e)){
                    if (windows.get(e).equals(need.get(e))){
                        count --;
                    }
                    windows.put(e , windows.get(e)-1);
                }
            }
        }
        return res;
    }


}
