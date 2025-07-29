//https://leetcode.com/problems/group-anagrams/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            String s1 = sort(s);
            if (res.containsKey(s1)) {
                res.get(s1).add(s);
            } else {
                List<String> group = new ArrayList<>();
                group.add(s);
                res.put(s1, group);
            }
        }

        return new ArrayList<>(res.values());
    }

    public String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

}
