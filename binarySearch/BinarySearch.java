package dataStructure.binarySearch;

/**
 * 二分查找的基本思路
 */
public class BinarySearch {
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

}
