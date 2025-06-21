// https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int maj = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                int cnt = map.get(n);
                if (cnt >= maj) {
                    return n;
                } else {
                    map.put(n, cnt + 1);
                }
            } else {
                map.put(n, 1);
            }
        }
        return 0;
    }
}
