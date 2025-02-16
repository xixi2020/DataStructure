package dataStructure.array.nSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *15. 三数之和
 * 中等
 * 提示
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * 提示：
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //首先要进行排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        //选出第一个数，如果后面两个数的值等于 负的当前值，就符合题意
        for (int i = 0; i < n - 2; i++) {
            //不可以包含重复的三元组，跳过当前的数
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //优化点:如果前三个数加起来大于0，后续绝对大于0直接排除
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
            //优化点：如果最后两个值加当前值已经小于0，那就一定比当前值大
            if (nums[i] + nums[n - 1] + nums[n - 2] < 0) continue;
            //和两数之和相同的做法
            int min = i + 1;
            int max = n - 1;
            while (min < max) {
                int sum = nums[i] + nums[min] + nums[max];
                //先确定第一个值
                if (sum > 0) {
                    max--;
                } else if  (sum < 0) {
                        min++;
                    } else {
                        //刚好为0，这时候返回三元组
                        res.add(Arrays.asList(nums[i], nums[min], nums[max]));
                        //注意这里也要给min和max去重
                        min ++;
                        //最左边的值一样
                        while(min < max && nums[min] == nums[min - 1])
                            min ++;
                        max --;
                        while(min < max && nums[max] == nums[max + 1])
                            max --;
                }
            }
        }
        return res;
    }
}
