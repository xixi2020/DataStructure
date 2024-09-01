package dataStructure.backtrackingAlgorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 中等
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 */
public class Permute {
    //接收排列组合
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        //记录路径的集合
        LinkedList<Integer> path = new LinkedList<>();
        //标记经过的路径为true
        boolean[] used = new boolean[nums.length];

        //进行路径选择
        backTrack(nums, path, used);
        return res;

    }

    private void backTrack(int[] nums, LinkedList<Integer> path, boolean[] used) {
        //规定结束条件,遍历完一次路径了
        if (path.size() == nums.length){
            res.add(new LinkedList<>(path));
            return;
        }
        //记录选择的路径
        for (int i = 0; i < nums.length; i++) {
            //是否被标记了
            if (used[i]){
                //已经被标记
                continue;
            }
            path.add(nums[i]);
            //标记已经路过
            used[i] = true;
            //进入下一层也就是除了当前数字之外其他的排列
            backTrack(nums, path, used);
            //当目前这一个数遍历完成之后，开始遍历下一个数，要把当前数去除,也就是取消
            path.removeLast();
            used[i] = false;
        }
    }
}
