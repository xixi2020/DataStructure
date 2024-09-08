package dataStructure.backtrackingAlgorithm;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * 提示：
 * 1 <= n <= 8
 */
public class GenerateParenthesis {
    //回溯路径，使用stringbuild来记录
    StringBuilder track = new StringBuilder();
    //记录合法的括号组合
    ArrayList<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        //经典回溯算法： `2n` 个位置，每个位置可以放置字符 `(` 或者 `)`，组成的所有括号组合中，有多少个是合法的？
        //得到全部 `2^(2n)` 种组合，再根据规则来选出合法的
        backtrack(n, n);
        return res;

    }

    private void backtrack(int left, int right) {
        //合法规则：若左括号剩下的多，说明不合法
        if (right < left) return;
        //合法规则：数量不可以小于0。也就是数量相等
        if (right < 0 || left < 0) return;
        //所有括号用完，记录合法括号
        if (left == 0 && right == 0){
            res.add(track.toString());
            return;
        }
        //做选择：放入一个左括号
        track.append('(');
        //不重复匹配
        backtrack(left - 1, right);
        //匹配完成进行撤销
        track.deleteCharAt(track.length() - 1);
        //做选择：放入一个右括号
        track.append(')');
        backtrack(left, right - 1);
        track.deleteCharAt(track.length() - 1);
    }
}
