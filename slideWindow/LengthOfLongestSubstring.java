package dataStructure.slideWindow;

import java.util.HashMap;
/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为
 */

public class LengthOfLongestSubstring {
        //两个指针，判断两个指针内的字符是否重复
        //这里是使用非滑动窗口，而是用hash表来存储不重复的位置索引
        public int lengthOfLongestSubstring(String s) {
            if (s.length()==0) return 0;
            //hashmap用来存字符以及字符所在的hashmap中的位置
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            //不重复的最大长度
            int max = 0;
            //最左边不重复的边界
            int left = 0;
            for(int i = 0; i < s.length(); i ++){
                if(map.containsKey(s.charAt(i))){
                    //从最开始重复的字母开始计算
                    left = Math.max(left,map.get(s.charAt(i)) + 1);
                }
                //添加数字，只用记录最左边的索引值即可。
                map.put(s.charAt(i),i);
                max = Math.max(max,i-left+1);
            }
            return max;

        }
        //这里使用滑动窗口的方式来做,未测试
        public int lengthOfLongestSubstring2(String s) {
            if (s.length()==0) return 0;
            //hashmap用来存字符以及字符所在的hashmap中的位置
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            //滑动窗口的左右边界
            int left = 0, right = 0;
            //记录结果
            int res = 0;
            //进行滑动窗口的活动
            while(right < s.length()){
                //判断最右边的字符是否存在
                char c = s.charAt(right);
                right++;
                map.put(c,map.getOrDefault(c,0)+1);
                //出现重复字符
                while(map.get(c) > 1){
                    //将最左边的移出去
                    char d = s.charAt(left);
                    left ++ ;
                    map.put(d, map.get(d)-1);
                }
                res = Math.max(res , right - left);
            }
            return res;

        }
}
