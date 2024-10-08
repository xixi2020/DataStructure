package dataStructure.array.twoPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 15. 三数之和
 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 注意：答案中不可以包含重复的三元组。
 示例 1：
 输入：nums = [-1,0,1,2,-1,-4]
 输出：[[-1,-1,2],[-1,0,1]]
 解释：
 nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 注意，输出的顺序和三元组的顺序并不重要。
 示例 2：
 输入：nums = [0,1,1]
 输出：[]
 解释：唯一可能的三元组和不为 0 。
 示例 3：
 输入：nums = [0,0,0]
 输出：[[0,0,0]]
 解释：唯一可能的三元组和为 0 。
 */
//public class ThreeSum {
//    //首先还是2sum无重复值的的解法
//    public List<List<Integer>> twoSum(int[] nums) {
//        int left = 0;
//        int right = nums.length;
//        //接收结果的集合
//        ArrayList<List<Integer>> res = null;
//        while(left < right){
//            int sum = nums[left] + nums[right];
//            //优化算法，记录最左和最右的原始值
//            int leftSum = nums[left];
//            int rightSum = nums[right];
//            if (sum < 0){
//                while (left < right && nums[left] == leftSum) left ++;
//            }else if (sum > 0){
//                while (left < right && nums[right] == rightSum) right--;
//            }else {
//                res.add(Collections.singletonList(left));
//                res.add(Collections.singletonList(right));
//            }
//
//        }
//        return res;
//
//    }
//    public List<List<Integer>> threeSum(int[] nums) {
//
//    }
//}
