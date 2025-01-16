package dataStructure.array.range;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * 中等
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * 示例 1：
 *
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 * 示例 2：
 *
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 * 示例 3：
 *
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
 *
 * 注意这里的提示:会有卡最小边界问题
 * -231 <= xstart < xend <= 231 - 1
 *
 */
public class FindMinArrowShots {
    public static void main(String[] args) {
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
        System.out.println(findMinArrowShots.findMinArrowShots(points));
    }
    //相交的就会被射穿，还是可以理解为有多少不相交的区间
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        //排序，以end升序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                //这里不能再使用这个了，会有边界问题，比如说-2147483645减去2147483647会超出int范围返回-1
//                return o2[1] - o1[1] ;
                //Integer内部解决了这个问题
                return Integer.compare(o1[1],o2[1]);

            }
        });
        System.out.println(Arrays.deepToString(points));

        //不重合的区间数
        int count = 1;
        //第一个区间的end
        int end = points[0][1];
        for (int[] temp : points) {
            int start = temp[0];
            //注意这里就算是点相交也算重合，就会被戳破
            if (start > end){
                count ++;
                //开始比下一个区间
                end = temp[1];
            }
        }
        return count;
    }

}
