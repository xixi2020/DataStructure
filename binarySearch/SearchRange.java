package dataStructure.binarySearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 中等
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        //这里直接用search进行解决
        int start = search(nums, target);
        if (start == nums.length || nums[start] != target){
            return new int[]{-1, -1};//nums中没有target
        }
        //start存在那么end也一定存在
        //找到第一个>8的数，并且返回它的左边的下标值
        int end = search(nums, target + 1) -1;
        return new int[]{start, end};


    }
    //闭区间找大于8的值
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //闭区间[left, right]
        while(left <= right){
            //这里可能会有缓存溢出的问题，所以使用left + (right - left)
            int mid = left + (right - left)/2;
            if( mid < target){
                //闭区间[mid + 1, right]
                left = mid + 1;
            }else if(mid < target){
                //[left, mid - 1]
                right = mid - 1;
            }
        }
        //可以找出规律，mid+1左边都是小于target的值，mid+1右边都是大于target的值
        return left;
    }
    //左闭右开
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;//右开
        //闭区间[left, right)
        while(left < right){
            int mid = (left + right)/2;
            if( mid < target){
                //闭区间[mid + 1, right]
                left = mid + 1;
            }else if(mid < target){
                //[left, mid)
                right = mid;
            }
        }
        //也可以是right
        return left;
    }
    //左右都是开区间
    public int search3(int[] nums, int target) {
        int left = -1;
        int right = nums.length;//右开
        //闭区间(left, right)
        while(left + 1< right){
            int mid = (left + right)/2;
            if( mid < target){
                //闭区间[mid + 1, right]
                left = mid;
            }else if(mid < target){
                //[left, mid)
                right = mid;
            }
        }
        //这里left和right都可以
        return left;
    }



}
