package dataStructure.backtrackingAlgorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 中等
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 *
 *
 */
public class CombinationSum {
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯的路径
    LinkedList<Integer> track = new LinkedList<>();
    // 记录 track 中的元素之和
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0){
            return res;
        }
        backtrack(candidates, 0, target);
        return res;

    }

    private void backtrack(int[] candidates, int start, int target) {
        //base base
        if (trackSum == target){
            res.add(new LinkedList<>(track));
            return;
        }
        //base base:相加超过目标值，直接结束
        if (trackSum > target){
            return;
        }
        //回溯遍历
        for (int i = start; i <candidates.length; i++) {
            //注意这里反而要剪枝
            track.add(candidates[i]);
            trackSum += candidates[i];
            //这里由于可无限重复使用，所以不用加1
            backtrack(candidates, i, target);
            //撤销足迹进行下一次遍历.只要有base条件即可
            track.removeLast();
            trackSum -= candidates[i];
        }

    }
}
