package threeweekschallange.medium;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {

    /**
     * Using same 2D array
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    /**
     * Using a new 2D array
     *
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix.length];
        int b = 0, a = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            a = matrix.length - 1;
            for (int j = 0; j < matrix.length; j++) {
                res[i][j] = matrix[a--][b];
            }
            b++;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }
}
