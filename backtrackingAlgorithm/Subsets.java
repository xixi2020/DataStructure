package dataStructure.backtrackingAlgorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 中等
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集（幂集）。解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class Subsets {
    //按照回溯法的经典框架做
    //保留结果
    List<List<Integer>> res = new LinkedList<>();
    //保留路径
    LinkedList<Integer> track = new LinkedList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        //具体的回溯流程
        backtrack(nums, 0);
        return res;
    }

    //遍历回溯子树
    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        //遍历子树
        for (int i = start; i < nums.length ; i++) {
            //添加路径
            track.addLast(nums[i]);
            //遍历当前这个数的所有结果子集和，也就是按顺序找比自己大的数
            backtrack(nums, i + 1);
            //撤销选择,开始下一轮
            track.removeLast();
        }

    }
}
