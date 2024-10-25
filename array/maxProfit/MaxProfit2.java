package dataStructure.array.maxProfit;

/**
 * 122. 买卖股票的最佳时机 II
 * 中等
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 */
public class MaxProfit2 {
    //动态规划函数
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            //base base
            if (i - 1 == -1){
                //没有开始的时候，利润为0
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            //今天没有持有股票的情况：昨天持有，昨天没有持有
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            //今天持有股票的情况：昨天持有，昨天没有持有:每次只能持有一支
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);

        }
        return dp[n - 1][0];

    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        //base base
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            //今天没有持有股票的情况：昨天持有，昨天没有持有
            dp_i_0 = Math.max(dp_i_0, dp_i_1  + prices[i]);
            //今天持有股票的情况：昨天持有，昨天没有持有:每次只能持有一支
            dp_i_1  = Math.max(dp_i_1 , dp_i_0 - prices[i]);

        }
        return dp_i_0;

    }
}
