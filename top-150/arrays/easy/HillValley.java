// https://leetcode.com/problems/count-hills-and-valleys-in-an-array/

class Solution {

    public int countHillValley(int[] nums) {

        int count = 0;
        
        for(int i = 1; i < nums.length - 1; i++) {
            
            int left = i - 1;
            int right = i + 1;
            
            while(right < nums.length && nums[i] == nums[right]) {
                right++;
            }
            

            if(right < nums.length && nums[i] != nums[right] && nums[i] != nums[left]) {
                if(nums[i] > nums[left] && nums[i] > nums[right]) {
                    count++;
                }
                if(nums[i] < nums[left] && nums[i] < nums[right]) {
                    count++;
                }
            }
        }
        
        return count;
    }
}


######################

class Solution {
  
    public int countHillValley(int[] nums) {
      
        int count = 0;
        int left = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                if ((nums[i] > nums[left] && nums[i] > nums[i + 1]) || 
                    (nums[i] < nums[left] && nums[i] < nums[i + 1])) {
                    count++;
                }
                left = i;
            }
        }
      
        return count;
    }
}
