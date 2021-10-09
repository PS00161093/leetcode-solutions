package threeweekschallange.medium;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class MatrixSearch {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) if (find(ints, target)) return true;
        return false;
    }

    private boolean find(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int mid = (low + high) / 2;

        while (low < high) {
            if (nums[mid] == target) return true;
            if (target > nums[mid]) low = low + 1;
            if (target < nums[mid]) high = high - 1;
            mid = (low + high) / 2;
        }

        return false;
    }

}
