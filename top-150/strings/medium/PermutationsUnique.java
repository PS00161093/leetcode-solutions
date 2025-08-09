// https://leetcode.com/problems/permutations-ii/description/
// TIME COMPLEXITY: O(n! × n) where n is length of nums array
// SPACE COMPLEXITY: O(n) for recursion and auxiliary arrays

class PermutationsUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort the array to handle duplicates efficiently
        Arrays.sort(nums);
        
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, 
                          int[] nums, boolean[] used) {
        // Base case: if current permutation has all elements
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Try each number at the current position
        for (int i = 0; i < nums.length; i++) {
            // Skip if already used
            if (used[i]) continue;
            
            // Skip duplicates: if current number equals previous AND previous is not used
            // This ensures we use duplicates in order (left to right)
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            
            used[i] = true;                          // Choose
            current.add(nums[i]);
            backtrack(result, current, nums, used);  // Explore
            current.remove(current.size() - 1);     // Backtrack
            used[i] = false;
        }
    }
}

/*
Example walkthrough:
Input: nums = [1,1,2] (after sorting: [1,1,2])

The key insight: To avoid duplicate permutations, we ensure that when we have 
duplicate numbers, we always use them in order (left to right).

Without the duplicate check, we'd generate:
- Use 1st '1', then 2nd '1': [1,1,2]
- Use 2nd '1', then 1st '1': [1,1,2] ← DUPLICATE!

With the duplicate check (i > 0 && nums[i] == nums[i-1] && !used[i-1]):
We only use the 2nd '1' if the 1st '1' is already being used.

Backtracking tree (with duplicate prevention):
                     []
                 /   |   \
               1/   1|   2\  (but 2nd 1 is skipped due to duplicate check)
               /     |     \
            [1]     [1]   [2]
           / \       \     / \
         1/   2\      2\  1/  1\  (but 2nd 1 after 1st is skipped)
         /     \       \  /    \
      [1,1]   [1,2]   [1,2] [2,1] [2,1] (but duplicate [2,1] prevented)
        |       |       |    |
        2       1       1    1
        |       |       |    |
    [1,1,2]  [1,2,1]  [1,2,1] [2,1,1]

After duplicate prevention: [[1,1,2], [1,2,1], [2,1,1]]

Algorithm explanation:
1. Sort the array to group duplicates together
2. Use boolean array to track which elements are currently in use
3. Skip duplicate elements unless we're using them in order (left to right)
4. The key condition: nums[i] == nums[i-1] && !used[i-1]
   - If current number equals previous number
   - AND the previous number is NOT currently being used
   - Then skip this number (to avoid duplicates)

Why this works:
- Sorting groups duplicates together
- We force a specific order for using duplicates (always left to right)
- This eliminates all duplicate permutations while keeping all unique ones

TIME COMPLEXITY: O(n! × n) where n is length of nums array
- In worst case (all elements unique), we generate n! permutations
- Each permutation takes O(n) time to build and copy
- Sorting takes O(n log n) but is dominated by the permutation generation

SPACE COMPLEXITY: O(n) for recursion and auxiliary arrays
- Recursion depth is O(n)
- used[] array takes O(n) space
- current list uses O(n) space during recursion
- Result space is O(n! × n) but that's the required output
*/
