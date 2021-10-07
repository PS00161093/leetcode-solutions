package twoweekschallange.easy;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SortedSquares {

    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int begin = 0;
        int end = n - 1;
        int index = n - 1;

        int[] res = new int[n];

        while (begin <= end) {
            if (Math.abs(nums[begin]) < Math.abs(nums[end])) {
                res[index--] = nums[end] * nums[end];
                end--;
            } else {
                res[index--] = nums[begin] * nums[begin];
                begin++;
            }
        }

        return res;
    }

    public int[] sortedSquares1(int[] nums) {

        int len = nums.length;
        int[] res = new int[len];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int n : nums) {
            if (map.containsKey(n * n)) map.put(n * n, map.get(n * n) + 1);
            else map.put(n * n, 1);
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int count = e.getValue();
            while (count > 0) {
                res[i] = e.getKey();
                i++;
                count--;
            }
        }

        return res;
    }

}