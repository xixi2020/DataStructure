package dataStructure.array.range;

import java.util.Arrays;

/**
 * 1288. 删除被覆盖区间
            * 中等
            * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
            * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
            * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
            * 示例：
            *
            * 输入：intervals = [[1,4],[3,6],[2,8]]
            * 输出：2
            * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
            */
    public class RemoveCoveredIntervals {
        public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]]
        int[][] srgs = {{1,3},{2,6},{8,10},{15,18}};
        RemoveCoveredIntervals mergeRange = new RemoveCoveredIntervals();
        System.out.println(mergeRange.removeCoveredIntervals(srgs));


    }
    int removeCoveredIntervals(int[][] intvs) {
        // 按照起点升序排列，起点相同时降序排列
        Arrays.sort(intvs, (int[] a, int[] b) -> {
            //这里是如果第一个数相同就按降序排序，后面是附加条件
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // 记录合并区间的起点和终点
        int left = intvs[0][0];
        int right = intvs[0][1];

        int res = 0;
        for (int i = 1; i < intvs.length; i++) {
            // intv = [2,6]
            int[] intv = intvs[i];
            // 情况一，找到覆盖区间 intv[0]: 2  intv[1]:6
            if (left <= intv[0] && right >= intv[1]) {
                res++;
            }
            // 情况二，找到相交区间，合并
            if (right >= intv[0] && right <= intv[1]) {
                right = intv[1];
            }
            // 情况三，完全不相交，更新起点和终点
            if (right < intv[0]) {
                left = intv[0];
                right = intv[1];
            }
        }

        return intvs.length - res;
    }

}
