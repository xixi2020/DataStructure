package dataStructure.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class twoSum {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        //用hash来做，key存当前的数组，再判断target减当前值是否在数组里，有就存索引
        Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]),i};
            }
            hashMap.put(nums[i], i);
        }

        return new int[0];
    }

}
