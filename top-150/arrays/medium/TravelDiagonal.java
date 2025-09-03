// https://leetcode.com/problems/diagonal-traverse/description/

class TravelDiagonal {
  
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int nums[] = new int[m * n];
        int row = 0;
        int col = 0;
        boolean up = true;
        int i = 0;

        while (row < m && col < n) {
            if (up) {
                while (row > 0 && col < n - 1) {
                    nums[i] = mat[row][col];
                    i++;
                    row--;
                    col++;
                }
                nums[i] = mat[row][col];
                i++;
                if (col == n - 1) {
                    row++;
                } else {
                    col++;
                }
            } else {
                while (row < m - 1 && col > 0) {
                    nums[i] = mat[row][col];
                    i++;
                    row++;
                    col--;
                }
                nums[i] = mat[row][col];
                i++;
                if (row == m - 1) {
                    col++;
                } else {
                    row++;
                }
            }
            up = !up;
        }

        return nums;
    }
}
