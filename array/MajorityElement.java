package dataStructure.array;

/**
 *169. 多数元素
 * 简单
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int votes = 0;
        int number = 0;
        //用消杀的方法来解决问题，进行投票，如果是众数，与所有数抵消了也会余下1
        for (int num : nums) {
            if (votes == 0) number = num;
            //与每个数进行消杀，最后只剩下一个就是众数
            votes = votes + (num == number ? 1 : -1);

        }
        return number;
    }
}
