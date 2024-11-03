package dataStructure.array.greedyAlgorithm;

/**
 * 134. 加油站
 * 中等
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * 示例 1:
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 *
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 */
public class CanCompleteCircuit {
    //图像解法：具体思路看文档
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //确定坐标值，x的坐标值
        int n = gas.length;
        //计算y轴值：也就是耗油量
        int sum = 0;
        //记录最低值使得处于x轴上方
        int minSum = 0;
        //计算结果
        int start = 0;
        //开始建立坐标
        for (int i = 0; i < n; i++) {
            //计算y轴值
            sum += gas[i] - cost[i];
            //取最小值
            if (sum < minSum){
                //因为减了cos[i]是最低点，所以最低点x是[i +1]
                start = i + 1;
                minSum = sum;
            }
        }
        //无解的情况，加油量小于消耗量
        if (sum < 0){
            return -1;
        }
        return start == n? 0 : start;
    }
    //贪心算法
     public int canCompleteCircuit2(int[] gas, int[] cost) {
        //遍历的次数
        int n = gas.length;
        int sum = 0;
        //排除无解的情况：即油量供给小于消耗
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) return -1;
        //选择路径：如果任意两点间出现油箱为负，那么中间节点都无法完成环岛
        //油箱剩余量
        int tank = 0;
        //起点
        int start = 0;
        //开始建立坐标
        for(int i = 0; i < n; i++) {
            //计算不同起点油箱的剩余量
            tank += gas[i] - cost[i];
            if (tank < 0){
                //重新选择路径，油箱清0
                tank = 0;
                start = i + 1;
            }
        }
        return start == n? 0 : start;
    }
}
