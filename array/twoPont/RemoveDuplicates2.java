package dataStructure.array.twoPont;

/**80. 删除有序数组中的重复项 II
 中等
 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *示例 1：
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 *
 */
public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        //还是使用快慢指针，只不过这是逆袭向思维，从后面往前面比
        if (nums.length == 0) return 0;
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast ++){
            if (nums[fast] != nums[slow - 2]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
