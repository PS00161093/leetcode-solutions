// https://leetcode.com/problems/strobogrammatic-number-ii/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
// TIME COMPLEXITY: O(5^(n/2) × n)
// SPACE COMPLEXITY: O(5^(n/2) × n)
// When building a strobogrammatic number of odd length (like 3, 5, 7...), the middle digit is special. It can't be a pair, so it must be one of "0", "1", or "8".
// The recursion starts with n == 1, which returns ["0", "1", "8"]. These are used as the center of the number.
// Then, pairs like ("1", "1"), ("6", "9"), etc., are added around this center to build up the full number.

class Strobogrammatic2 {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int n, int originalN) {
        if (n == 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("0", "1", "8");
        
        List<String> list = helper(n - 2, originalN);
        List<String> result = new ArrayList<>();
        
        for (String s : list) {
            result.add("1" + s + "1");
            result.add("8" + s + "8");
            result.add("6" + s + "9");
            result.add("9" + s + "6");
            
            if (n != originalN) {
                result.add("0" + s + "0");
            }
        }
        
        return result;
    }
}
