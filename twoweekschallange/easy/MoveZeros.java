package twoweekschallange.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) j++;
            else {
                nums[i] = nums[j];
                j++;
                i++;
            }
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }

    public void moveZeroes1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) if (n != 0) list.add(n);
        for (int n : nums) if (n == 0) list.add(n);
        int i = 0;
        for (int n : list) {
            nums[i] = n;
            i++;
        }
    }

    public void moveZeroes2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) if (n != 0) list.add(n);
        int i = 0;
        for (int n : list) {
            nums[i] = n;
            i++;
        }
        int diff = nums.length - i;
        while (diff > 0) {
            nums[i] = 0;
            diff--;
            i++;
        }
    }
}
