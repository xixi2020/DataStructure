package dataStructure.dynamicProgramming;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 */
public class CoinChange {
    //备忘录优化算法，记录已经取到结果的值
    int[] num;
    public int coinChange(int[] coins, int amount){
        //基础动态规划
//        return dp(coins, amount);
        //备忘录优化的方式
        num = new int[amount + 1];
        //初始化一个不会被取到的值
        Arrays.fill(num,-2);
        return dp2(coins, amount);
    }

    private int dp2(int[] coins, int amount) {
        //base条件
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        //记录最少使用硬币
        int res = Integer.MAX_VALUE;
        if (num[amount] != -2 ){
            return num[amount];
        }
        //记录每种硬币需要的个数
        for (int coin : coins){
            //子集结果
            int subPorblem = dp(coins, amount - coin);
            //已经是最小值了：无解，跳过本次循环
            if (subPorblem == -1) continue;
            res = Math.min(res, subPorblem +1 );
        }
        //用记录表记录每种数值的最小值
        num[amount]  = (res == Integer.MAX_VALUE)?-1 : res;
        //去除没有符合的硬币的情况
        return num[amount];

    }


    //基本动态规划公式，但会超时
    int dp(int[] coins, int amount){
        //base条件
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        //记录最少使用硬币
        int res = Integer.MAX_VALUE;
        //记录每种硬币需要的个数
        for (int coin : coins) {
            //子集结果
            int subPorblem = dp(coins, amount - coin);
            //已经是最小值了：无解，跳过本次循环
            if (subPorblem == -1) continue;
            res = Math.min(res, subPorblem +1 );
        }
        //去除没有符合的硬币的情况
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    //使用备忘录优化

}
