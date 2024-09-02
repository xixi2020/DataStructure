package dataStructure.backtrackingAlgorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 用模板的方式来解决全排列的问题
 */
public class Permute02 {
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();
    // track 中的元素会被标记为 true
    boolean[] used;
    // 主函数，输入一组不重复的数字，返回它们的全排列
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
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
            used[i] = true;
            track.addLast(nums[i]);
            //进行下一层回溯
            backtrack(nums);
            track.removeLast();
            used[i] = false;
            
        }
    }
}
