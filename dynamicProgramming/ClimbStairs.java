package dataStructure.dynamicProgramming;

/**
 * 70. 爬楼梯
 * 简单
 * 提示
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 *
 * 提示：
 *
 * 1 <= n <= 45
 */
public class ClimbStairs {
    //用具体赋值的顺序差来达到n-1和n-2的效果
    public int climbStairs(int n) {
        //f(n) = f(n - 1) + f(n - 2)
        //q: n-2 p: n-1
        int q = 0, p = 0, res = 1;
        //base base n=1 res:2 n=2 res:2
        for( int i = 1; i <= n; i++){
            //n-2
            q = p;
            //n-1
            p = res;
            res = q + p;
        }
        return res;

    }
}
