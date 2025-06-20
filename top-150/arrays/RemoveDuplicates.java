// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    // Option: 1
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    // Option: 2
    public int removeDuplicates2(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int n : nums) {
            set.add(n);
        }
        Iterator<Integer> iterator = set.iterator();
        int j = 0;
        while (iterator.hasNext()) {
            nums[j] = iterator.next();
            j++;
        }

        return set.size();
    }
}
