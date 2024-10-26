package dataStructure.array.range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 * 中等
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Merge {
    public static void main(String[] args) {
        int[][] ints = {{1,3},{2,6},{8,10},{15,18}};
        Merge merge = new Merge();
        int[][] merge1 = merge.merge(ints);
        for (int i = 0; i < merge1.length; i++) {
            for (int j = 0; j < merge1[i].length; j++) {
                System.out.print("[" + merge1[i][j] + "]");
            }

        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        //先排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        ArrayList<int[]> res = new ArrayList<>();
        //收集结果
        //加入第一个数组
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = intervals[i];
            //每个数组最后一个数
            int[] last = res.get(res.size() - 1);
            if (temp[0] <= last[1]) {
                //比较结尾大小
                last[1] = Math.max(last[1], temp[1]);
            } else {
                //加入下一段
                res.add(temp);
            }
        }
        return res.toArray(new int[0][0]);
    }

}
