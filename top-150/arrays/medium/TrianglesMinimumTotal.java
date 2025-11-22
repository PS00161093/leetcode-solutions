// https://leetcode.com/problems/triangle

class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        for (int row = 1; row < n; row++) {

            for (int col = 0; col < triangle.get(row).size(); col++) {

                int curr = triangle.get(row).get(col);

                int minAbove = Integer.MAX_VALUE;

                if (col > 0) {
                    minAbove = Math.min(minAbove, triangle.get(row - 1).get(col - 1));
                }

                if (col < triangle.get(row - 1).size()) {
                    minAbove = Math.min(minAbove, triangle.get(row - 1).get(col));
                }

                triangle.get(row).set(col, curr + minAbove);
            }
        }

        return Collections.min(triangle.get(n - 1));
    }
}
