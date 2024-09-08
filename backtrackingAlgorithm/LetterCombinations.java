package dataStructure.backtrackingAlgorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 中等
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class LetterCombinations {
    //每个数字到字⺟的映射
    String[] mapping = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
            "wxyz"
    };
    //记录结果
    LinkedList<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        //进行组合
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int start, StringBuilder stringBuilder) {
        //回溯到最底层
        if (stringBuilder.length() == digits.length()){
            res.add(stringBuilder.toString());
        }
        //回溯框架
        for (int i = start; i < digits.length(); i++) {
            //字符和数字之间的转换
            int digit = digits.charAt(i) - '0';
            //在九个键盘中做选择
            for (char c : mapping[digit].toCharArray() ) {
                stringBuilder.append(c);
                //递归到下一层
                backtrack(digits,  i + 1, stringBuilder);
                //撤销选择
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
}
