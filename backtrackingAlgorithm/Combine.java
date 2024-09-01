package dataStructure.backtrackingAlgorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合 中等
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combine {
    //用经典回溯法去做，区别于子集在于收集哪一层子树的路径值，k为2，就收集第二层的
    //保留结果
    List<List<Integer>> res = new LinkedList<>();
    //保留路径
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        //具体的回溯流程
        backtrack(1, n, k);
        return res;
    }

    //遍历回溯子树
    private void backtrack(int start, int n, int k) {
        //收集当前层数的值，也就是n的值
        if (k == track.size()){
            res.add(new LinkedList<>(track));
            return;
        }

        //遍历子树
        for (int i = start; i <= n; i++) {
            //添加路径
            track.addLast(i);
            //遍历下一个数的全部集合
            backtrack(i + 1, n, k);
            //撤销选择,开始下一轮
            track.removeLast();
        }

    }
}
