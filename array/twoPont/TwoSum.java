package dataStructure.array.twoPont;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        //只要是有序的数组，就应该联想起使用二分法
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int num = numbers[left] + numbers[right];
            if ( num == target){
                return new int[]{left + 1, right + 1};
            }else if (num < target){
                //让数大一点
                left ++;
            }else {
                //让数小一点
                right --;
            }
        }
        return new int[]{-1, -1};
    }
}
