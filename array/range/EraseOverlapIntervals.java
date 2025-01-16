package dataStructure.array.range;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 *
 * 注意 只在一点上接触的区间是 不重叠的。例如 [1, 2] 和 [2, 3] 是不重叠的。
 *
 *
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class EraseOverlapIntervals {
    //这里用整个数组的元素个数减去最多有几个不相交的区间
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        //按照end进行升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //记录第一个end
        int end = intervals[0][1];
        //记录不重叠的区间个数,以第一个区间为基准，基数为1
        int count = 1;
        //开始遍历每个区间
        for (int[] temp: intervals) {
            //记录开始
            int start = temp[0];
            //注意这里开始的点与结束的点重合不算重合
            if(start >= end){
                count ++;
                //开始比下一个区间
                end = temp[1];
            }
        }
        return intervals.length - count;
    }
}
