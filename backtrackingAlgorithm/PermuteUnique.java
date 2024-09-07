package dataStructure.backtrackingAlgorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II 重复不可重复选
 * 中等
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 */
public class PermuteUnique {
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();
    // track 中的元素会被标记为 true
    boolean[] used;
    // 主函数，输入一组不重复的数字，返回它们的全排列
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        //base,base
        //达到叶子节点进行记录，也就是路径包括了所有的数
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
//        //如果是元素为k，和组合一样在相关层数进行收集即可
//        if (track.size() == k){
//            res.add(new LinkedList<>(track));
//            return;
//        }
        for (int i = 0; i < nums.length; i++) {
            //如果已经被标记了
            if (used[i]){
                continue;
            }
            //剪枝逻辑，保证重复数的先后顺序，用标记来判断
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }

            track.addLast(nums[i]);
            used[i] = true;
            //进行下一层回溯
            backtrack(nums);
            track.removeLast();
            //消除足迹
            used[i] = false;

        }
    }
}
