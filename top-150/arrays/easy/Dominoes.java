// https://leetcode.com/problems/number-of-equivalent-domino-pairs/

class Dominoes {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int[] d : dominoes) {
            String key = d[0] < d[1] ? d[0] + "," + d[1] : d[1] + "," + d[0];
            res = res + map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return res;
    }
}
