// https://leetcode.com/problems/number-of-islands/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count = count + 1;
                    checkAdjacent(grid, i, j);
                }
            }
        }

        return count;
    }

    public void checkAdjacent(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[i].length
                || grid[i][j] == '0') {

            return;
        }

        grid[i][j] = '0';
        checkAdjacent(grid, i + 1, j);
        checkAdjacent(grid, i - 1, j);
        checkAdjacent(grid, i, j - 1);
        checkAdjacent(grid, i, j + 1);
    }
}
