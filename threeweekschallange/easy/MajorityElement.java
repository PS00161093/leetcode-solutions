package threeweekschallange.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

    @Override
    public String toString() {
        return "MajorityElement{}";
    }

    public int majorityElement(int[] nums) {

        int majority = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) map.put(n, map.get(n) + 1);
            else map.put(n, 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > majority) return e.getKey();
        }


        return 0;
    }
}