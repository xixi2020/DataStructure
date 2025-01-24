package dataStructure.dynamicProgramming;

import java.util.Arrays;

/**
 * 198. 打家劫舍
 * 中等
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 */
public class Rob {
    //备忘录来记录每一个选择的最优解
    private int[] note;
    public int rob(int[] nums) {
        //状态转移方程,每一次选择的最优解
        //经典递归实现一维动态规划，但这个方法会超时
//        return dp(nums, 0);
        //使用备忘录进行优化,将备忘录初始化为-1
        note = new int[nums.length];
        Arrays.fill(note, -1);
        return dp2(nums, 0);
    }
    //进一步优化，由底向上
    private int rob2(int[] nums){
        int n = nums.length;
        //再进一步优化，动态转移方程与两个状态相关int n = nums.length;
        //第n个选择 dp(n) = 0
        int[] dp = new int[n + 2];
        //注意这里是i - 1
        for (int i = n - 1; i >= 0 ; i--) {
            dp[i] = Math.max(dp[i + 1],dp[i + 2] + nums[i]);
        }
        return dp[0];
    }

    private int rob3(int[] nums){
        //两个状态变量 dp[i + 1] dp[i + 2]
        int dp_i_1 = 0,dp_i_2 = 0;
        //dp[i]
        int dp_i = 0;
        //注意这里是i - 1
        for (int i = nums.length - 1; i >= 0 ; i--) {
            dp_i= Math.max(dp_i_1, dp_i_2 + nums[i]);
            //每次接收上一次的结果
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    private int dp2(int[] nums, int start) {
        //base
        if (start >= nums.length) return 0;
        //如果已经被记录直接返回记录
        if (note[start] != -1) return note[start];
        int res = Math.max(dp(nums, start + 1),
                nums[start] + dp(nums, start + 2));
        note[start] = res;
        return res;
    }

    private int dp(int[] nums, int start) {
        //base: 当到最后一个屋子，没有办法在进行盗窃，也就是没有 start + 1 或者 start + 2
        if( start >= nums.length) return 0;
        //开始记录每一次start的最大盗窃金额
        int res = Math.max(
                //不盗窃当前住户，可以在下一次选择是否盗窃
                dp(nums, start + 1),
                //盗窃当前住户，那么需要间隔一家住户
                nums[start] + dp(nums, start + 2)
        );
        return res;
    }

}
