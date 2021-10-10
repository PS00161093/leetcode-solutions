package threeweekschallange.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubArraySum {

    public static int subArraySum(int[] nums, int k) {

        if (nums.length == 0) return 0;

        int sum = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int cur : nums) {
            sum += cur;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
