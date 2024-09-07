package dataStructure.backtrackingAlgorithm;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 提示:
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class CombinationSum2 {
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯的路径
    LinkedList<Integer> track = new LinkedList<>();
    // 记录 track 中的元素之和
    int trackSum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;

    }

    private void backtrack(int[] nums, int start, int target) {
        //base base
        if (trackSum == target){
            res.add(new LinkedList<>(track));
            return;
        }
        //base base:相加超过目标值，直接结束
        if (trackSum > target){
            return;
        }
        for (int j = start; j < nums.length; j++) {
            //剪枝逻辑，重复的数剪掉
            if (j > start && nums[j] == nums[j - 1]){
                continue;
            }
            track.add(nums[j]);
            trackSum += nums[j];
            //回溯遍历下一层
            backtrack(nums, nums[j] + 1, target);
            //撤销
            track.removeLast();
            trackSum -= nums[j];
        }
    }
}
