package dataStructure.array.twoPont;

/**
 * 5. 最长回文子串
 * 中等
 * 给你一个字符串 s，找到 s 中最长的回文子串
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abcd";
        LongestPalindrome longestPalindrome = new LongestPalindrome();

        System.out.println(longestPalindrome.longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //要考虑到是奇数还是偶数的问题
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = s1.length() > res.length() ? s1 : res;
            res = s2.length() > res.length() ? s2 : res;

        }
        return res;
    }
    //由中间向两边扩散，以s为中心
    String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            //向两边扩散
            l --;
            r ++;
        }
        return s.substring(l + 1, r);
    }
}
