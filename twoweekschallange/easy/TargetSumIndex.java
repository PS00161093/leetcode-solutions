package twoweekschallange.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TargetSumIndex {

    public int[] twoSum(int[] numbers, int target) {

        int[] pos = {0, 0};
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                pos[0] = i + 1;
                pos[1] = j + 1;
                break;
            }
            else if (sum < target) i++;
            else j--;
        }

        return (pos);
    }
    
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[1] = i;
                ans[0] = map.get(target - nums[i]);
                return ans;
            }

            map.put(nums[i], i);
        }

        return ans;
    }    

    public int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int n : numbers) {
            if (set.contains(target - n)) {
                res[1] = getIndexFromBack(numbers, n) + 1;
                res[0] = getIndex(numbers, target - n) + 1;
            } else set.add(n);
        }
        return res;

    }

    private int getIndex(int[] arr, int num) {
        int x = -1;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] == num) {
                x = i;
                break;
            }
        }

        return x;
    }

    private int getIndexFromBack(int[] arr, int num) {
        int x = -1;
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] == num) {
                x = i;
                break;
            }
        }

        return x;
    }
}
