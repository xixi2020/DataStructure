package dataStructure.array.maxProfit;

/**
 *121. 买卖股票的最佳时机
 * 简单
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 */
public class MaxProfit {
    //用动态规划的方法进行解答：不计较k的情况，也就是没有交易限制
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //int[..][0]/[1] 0，1 分别代表是否持有股票
        //状态方程
        int [][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            //base base 状态停止条件 i=0 的时候 i-1 不合法
            if (i - 1 == -1 ){
                //还没有开始持股
                dp[i][0] = 0;
                //还没开始的时候，是不可能持有股票的，我们的算法要求一个最大值，所以初始值设为一个最小值，方便取最大值。
                dp[i][1] = -prices[i];
                continue;
            }
            //没有持有股票：昨天没有持有，昨天持有
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //持有股票：昨天持有，昨天没有持有（今天买了）
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);

        }
        //最后卖掉
        return dp[n - 1][0];
    }

    //优化：空间复杂度优化 数组换成单一的变量
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        //int[..][0]/[1] 0，1 分别代表是否持有股票
        //状态方程 base base 还没开始的时候利润为0，也不可能持有股票
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            //没有持有股票：昨天没有持有，昨天持有
            dp_i_0 = Math.max(dp_i_0, dp_i_1+ prices[i]);
            //持有股票：昨天持有，昨天没有持有（今天买了）
            dp_i_1 = Math.max(dp_i_1, - prices[i]);

        }
        return  dp_i_0;
    }



}
