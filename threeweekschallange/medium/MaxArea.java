package threeweekschallange.medium;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class MaxArea {

    // O(n)
    public int maxArea(int[] height) {
        int maxArea = 0, i = 0, j = height.length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) i++;
            else j--;
        }

        return maxArea;
    }

    // O(n^2)
    public int maxArea1(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int len = j - i;
                int bre = Math.min(height[i], height[j]);
                maxArea = Math.max(len * bre, maxArea);
            }
        }

        return maxArea;
    }
}
