// https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] newNums = new int[len];
        for (int i = 0; i < len; i++) {
            int targetIndex = (i + k) % len;
            newNums[targetIndex] = nums[i];
        }
        
        for(int i = 0; i < len; i++) {
            nums[i] = newNums[i];
        }
    }
}
