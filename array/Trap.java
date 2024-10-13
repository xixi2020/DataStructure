package dataStructure.array;

/**
 * 42. 接雨水
 * 困难
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：

 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 */
public class Trap {
    //这里使用三种解法解决接雨水的问题
    //暴力解法:超时
    public int trap1(int[] height) {
        int res = 0;
        int n = height.length;
        //思路：i点最大面积是旁边的最高点减去当前点的高度
        for (int i = 1; i < n - 1 ; i++) {
            int leftMax = 0, rightMax = 0;
            //找右边最高的点
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            //找左边最高点
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            //自己就是最高点
            res = res + Math.min(rightMax, leftMax) - height[i];
        }
        return res;

    }

    //优化暴力解法：使用备忘录记录当前位置左右的最大值
    public int trap2(int[] height) {
        if (height.length == 0) return 0;
        int res = 0;
        int n = height.length;
        //备忘录初始化
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        //初始化备忘录
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        
        //记录leftMax
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i] , leftMax[i - 1]);
        }
        //记录rightMax
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i] , rightMax[i + 1]);
        }
        //计算height[i]的最大值
        for (int i = 1; i < n - 1 ; i++) {
            res = res + Math.min(rightMax[i], leftMax[i]) - height[i];
        }
        return res;
    }

    //双指针解法：较为复杂
    public int trap3(int[] height) {
        int left = 0, right = height.length - 1;
        //记录指针所指范围内的最大值
        int leftMax = 0, rightMax = 0;
        int res = 0;

        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            //只关注比较低的一方，可以理解为两边同时找最高点
            if(leftMax < rightMax) {
                res = res + leftMax - height[left];
                left ++;
            }else {
                res = res + rightMax - height[right];
                right --;
            }
        }
        return res;
    }
}
