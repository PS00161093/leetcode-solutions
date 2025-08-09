// https://leetcode.com/problems/permutations/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
// TIME COMPLEXITY: O(n! × n) where n is length of nums array, There are n! permutations total, each takes O(n) time to build and check
// SPACE COMPLEXITY: O(n! × n) for storing all permutations, Result contains n! permutations, each with n elements

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        }

        for (int n : nums) {
            if (current.contains(n)) {
                continue;
            }

            current.add(n);
            backtrack(result, current, nums);
            current.remove(current.size() - 1);
        }
    }
}
