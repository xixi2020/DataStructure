package dataStructure.slideWindow;

import java.util.HashMap;

/**
 * 209. 长度最小的子数组
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
            //维护滑动窗口的左右边界
            int left = 0, right = 0;
            //记录结果
            int res = 0;
            //记录长度
            int len = Integer.MAX_VALUE;
            while(right < nums.length){
                res = res + nums[right];
                right ++;
                //缩小窗口,如果和大于等于目标值，就缩小窗口
                while(res >= target){
                    len = Math.min(len, right - left);
                    //移除最左边
                    res = res - nums[left];
                    left ++;
                }
            }
            return len == Integer.MAX_VALUE ? 0 : len;
        }

}
