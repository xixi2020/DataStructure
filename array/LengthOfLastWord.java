package dataStructure.array;

/**
 * 58. 最后一个单词的长度
 * 简单
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为 5。
 * 示例 2：
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为 4。
 * 示例 3：
 *
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为 6 的“joyboy”。
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        //从尾部遍历字符串直到为空字符串结束
        int index = s.length() - 1;
        //如果最后一个字符为空，往前遍历直到最后一个单词
        while(s.charAt(index) == ' '){
            index --;
        }
        int wordLen = 0;
        while (index >= 0 && s.charAt(index) != ' ' ){
            wordLen ++;
            index --;
        }
        return wordLen;
    }
}
