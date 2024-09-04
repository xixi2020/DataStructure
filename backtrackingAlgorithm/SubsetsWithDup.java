package dataStructure.backtrackingAlgorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
 * 子集
 * （幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class SubsetsWithDup {
    //保留结果
    List<List<Integer>> res = new LinkedList<>();
    //保留路径
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //首先给数组按顺序排列，使重复的排在一起
        Arrays.sort(nums);
        //回溯算法
        backtrack(nums,0);
        return res;

    }

    private void backtrack(int[] nums, int start) {
        //添加路径,每个结点都是一个子集
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length ; i++) {
            //剪枝逻辑，将重复的枝剪掉,退出本次循环
            if (i > start && nums[i] == nums[i - 1]){
                continue;
            }
            //添加路径
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();

        }
    }


}
