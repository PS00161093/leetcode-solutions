package threweekschallange.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * challange.easy.SearchInsert - https://leetcode.com/problems/single-number/
 */

public class SingleUniqueNumber {

    public int singleUniqueNumber(int[] nums, int target) {

        int number = 0;
        for (int num : nums) number = number ^ num; //XOR operations
        return number;
    }

    public int singleUniqueNumber1(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) map.put(n, map.get(n) + 1);
            else map.put(n, 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) return e.getKey();
        }

        return 0;
    }

}