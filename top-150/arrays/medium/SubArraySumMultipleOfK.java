// https://leetcode.com/problems/continuous-subarray-sum/submissions/1728667828/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
// Time complexity: O(n) - single pass through the array
// Space complexity: O(min(n,k)) - at most we store k different remainders or n elements

class SubArraySumMultipleOfK {
  
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int currSum = 0;

        for (int i = 0; i < len; i++) {
            currSum = currSum + nums[i];
            int rem = currSum % k;

            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }

        return false;
    }
}
