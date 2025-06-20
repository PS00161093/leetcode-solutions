// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n: nums) {
            if(i < 2 || n > nums[i-2]) {
                nums[i] = n;
                i++;
            }
        }

        return i;
    }
}
