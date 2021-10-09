package threeweekschallange.medium;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrix {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int left = 0, top = 0;
        int right = n - 1, down = n - 1;
        int count = 1;

        while (left <= right) {

            count = fillRight(matrix, left, top, right, count);
            top++;

            count = fillDown(matrix, top, right, down, count);
            right--;

            count = fillLeft(matrix, left, right, down, count);
            down--;

            count = fillUp(matrix, left, top, down, count);
            left++;
        }

        return matrix;
    }

    private int fillUp(int[][] matrix, int left, int top, int down, int count) {

        for (int i = down; i >= top; i--) {
            matrix[i][left] = count++;
        }

        return count;
    }

    private int fillLeft(int[][] matrix, int left, int right, int down, int count) {

        for (int j = right; j >= left; j--) {
            matrix[down][j] = count++;
        }

        return count;
    }

    private int fillDown(int[][] matrix, int top, int right, int down, int count) {

        for (int i = top; i <= down; i++) {
            matrix[i][right] = count++;
        }

        return count;
    }

    private int fillRight(int[][] matrix, int left, int top, int right, int count) {

        for (int j = left; j <= right; j++) {
            matrix[top][j] = count++;
        }

        return count;
    }
}
