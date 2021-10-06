package twoweekschallange.easy;

public class BinarySearch {

    /**
     * Binary search - https://leetcode.com/problems/binary-search/
     */
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length;
        int mid = (low + high) / 2;

        while (low < high) {
            if (nums[mid] == target) return mid;
            if (target > nums[mid]) low = low + 1;
            if (target < nums[mid]) high = high - 1;
            mid = (low + high) / 2;
        }

        return -1;
    }

    public int search1(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}