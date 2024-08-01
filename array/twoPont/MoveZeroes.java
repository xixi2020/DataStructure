package dataStructure.array.twoPont;

import java.util.Arrays;

/**
 * 283. 移动零
 * 简单
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums  = {0,1,0,3,12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        //使用双指针进行解决
        //可以直接使用上面的移除指定的val
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != 0){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        for (int i = slow ; i < nums.length ; i++) {
            //服了这里写成slow了，脑子短路了
            nums[i] = 0;

        }


    }

}
