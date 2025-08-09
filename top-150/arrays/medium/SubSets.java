// https://leetcode.com/problems/subsets/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
// TIME COMPLEXITY: O(2^n × n) where n is length of nums array
// SPACE COMPLEXITY: O(2^n × n) for storing all subsets

class SubSets {
  
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}

/*
Example walkthrough:
Input: nums = [1,2,3]

Backtracking tree:
                    []  ← Add [] to result
                 /  |  \
               1/   2|   3\
               /    |     \
            [1] ← Add [1]  [2] ← Add [2]  [3] ← Add [3]
           / \              \              
         2/   3\             3\             
         /     \              \             
      [1,2] ← Add [1,2]     [2,3] ← Add [2,3]
        |                    
        3|                   
        |                    
    [1,2,3] ← Add [1,2,3]    

Step-by-step execution:
1. backtrack([], 0): Add [] to result
   - Try i=0 (nums[0]=1): current=[1]
     - backtrack([1], 1): Add [1] to result  
       - Try i=1 (nums[1]=2): current=[1,2]
         - backtrack([1,2], 2): Add [1,2] to result
           - Try i=2 (nums[2]=3): current=[1,2,3]
             - backtrack([1,2,3], 3): Add [1,2,3], no more elements
           - Backtrack: current=[1,2]
         - Backtrack: current=[1]
       - Try i=2 (nums[2]=3): current=[1,3]
         - backtrack([1,3], 3): Add [1,3] to result
       - Backtrack: current=[1]
     - Backtrack: current=[]
   - Try i=1 (nums[1]=2): current=[2]
     - backtrack([2], 2): Add [2] to result
       - Try i=2 (nums[2]=3): current=[2,3]
         - backtrack([2,3], 3): Add [2,3] to result
       - Backtrack: current=[2]
     - Backtrack: current=[]
   - Try i=2 (nums[2]=3): current=[3]
     - backtrack([3], 3): Add [3] to result
     - Backtrack: current=[]

Result: [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]

Algorithm explanation:
1. Use backtracking to generate all possible combinations
2. At each level, add current subset to results (all subsets are valid)
3. For each remaining element, decide whether to include it or not
4. Use 'start' index to avoid generating duplicate subsets
5. Key insight: We add to result at EVERY recursive call, not just at leaves

Why 'start' parameter works:
- Ensures we only consider elements after current position
- Prevents duplicates like [1,2] and [2,1] (we only generate [1,2])
- Creates systematic ordering: [] → [1] → [1,2] → [1,2,3] → [1,3] → [2] → [2,3] → [3]

Alternative approaches:
1. Iterative: Start with [[]], for each num, double the size by adding num to each existing subset
2. Bit manipulation: Use binary representation where each bit represents include/exclude

TIME COMPLEXITY: O(2^n × n) where n is length of nums array
- There are 2^n possible subsets (each element can be included or not)
- Each subset takes O(n) time to copy into the result list

SPACE COMPLEXITY: O(2^n × n) for storing all subsets
- Recursion depth is O(n)
- current list uses O(n) space during recursion  
- Result contains 2^n subsets, each with average length n/2
*/
